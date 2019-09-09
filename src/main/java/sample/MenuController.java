package sample;
import core.*;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.util.Callback;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.text.DecimalFormat;


public class MenuController {
    @FXML
    private TableView<SurfData> tblSurfList;
    @FXML
    private TableView<CodeHistory> tblCodeHistory;
    @FXML
    private TextField txtType;
    @FXML
    private TextField txtCode;
    @FXML
    private TextField txtTrendSignal;
    @FXML
    private TextField txtReferPrice;
    @FXML
    private TextField txtBoughtPrice;
    @FXML
    private TextField txtUpcutRate;
    @FXML
    private TextField txtDowncutRate;
    @FXML
    private TextField txtStyle;
    @FXML
    private TextField txtRemark;
    @FXML
    private WebView webView;

    @FXML
    protected void addItem(ActionEvent event){
        //Calculate Up cut price and Down cut Price
        ObservableList<SurfData> data = tblSurfList.getItems();
        double boughtPrice,upRate, downRate, upCutPrice = 0, downCutPrice = 0;
        upRate = Double.parseDouble(txtUpcutRate.getText())/100;
        downRate = Double.parseDouble(txtDowncutRate.getText())/100;
        boughtPrice = Double.parseDouble(txtBoughtPrice.getText());

        if (boughtPrice > 0){
            upCutPrice = Math.round(boughtPrice * (1 + upRate)*100);
            downCutPrice = Math.round(boughtPrice * (1 - downRate)*100);
        }

        //Add data to table view
        data.add(new SurfData(txtType.getText().trim(), txtCode.getText().trim().toUpperCase(), txtTrendSignal.getText().trim(), txtReferPrice.getText().trim(), txtBoughtPrice.getText().trim(),
                                txtUpcutRate.getText().trim()+ " %", String.valueOf(upCutPrice/100), txtDowncutRate.getText().trim()+ " %",String.valueOf(downCutPrice/100),
                                txtStyle.getText().trim(), txtRemark.getText().trim()));

        //Clear text fields
        txtType.setText("");
        txtCode.setText("");
        txtTrendSignal.setText("");
        txtUpcutRate.setText("");
        txtReferPrice.setText("");
        txtBoughtPrice.setText("");
        txtUpcutRate.setText("");
        txtDowncutRate.setText("");
        txtStyle.setText("");
        txtRemark.setText("");
    }

    @FXML
    public void removeItem(ActionEvent event) {
        tblSurfList.getItems().removeAll(tblSurfList.getSelectionModel().getSelectedItems());
        tblSurfList.getSelectionModel().clearSelection();
    }

    @FXML
    public void clearItem(ActionEvent actionEvent) {
        txtType.setText("");
        txtCode.setText("");
        txtTrendSignal.setText("");
        txtUpcutRate.setText("");
        txtReferPrice.setText("");
        txtBoughtPrice.setText("");
        txtUpcutRate.setText("");
        txtDowncutRate.setText("");
        txtStyle.setText("");
        txtRemark.setText("");
    }

    @FXML
    protected void viewHistory(ActionEvent event) throws IOException {
        ObservableList<CodeHistory> historyItem = FXCollections.observableArrayList();
        tblCodeHistory.setItems(historyItem);
        //Get HTML element
        SurfData clickedItem = tblSurfList.getSelectionModel().getSelectedItem();

        String url = "http://s.cafef.vn/Lich-su-giao-dich-"+clickedItem.getCode()+"-1.chn";

        Element currentRow = Jsoup.connect(url)
                                            .get()
                                            .body()
                                            .getElementById("ctl00_ContentPlaceHolder1_ctl03_rptData_ctl01_itemTR");
        //re-select element if changed
        if (currentRow == null){
            currentRow = Jsoup.connect(url)
                    .get()
                    .body()
                    .getElementById("ctl00_ContentPlaceHolder1_ctl03_rptData2_ctl01_itemTR");

        }

        Element nextRow = currentRow.nextElementSibling();
        Element tempt = nextRow;

        //Get data of 8 days and add to table view
        for(int i = 0; i <8; i++){
            String date = currentRow.selectFirst("> td.Item_DateItem").text().trim();
            String price = currentRow.selectFirst("> td:nth-child(3)").text().trim();
            String change = currentRow.selectFirst("> td.Item_ChangePrice").text().trim();
            SurfData sd = tblSurfList.getSelectionModel().getSelectedItem();

            historyItem = tblCodeHistory.getItems();

            Float check = Float.parseFloat(change.substring(0,5));

            //Color the price whether it went up or down
            if(check >= 0){
                Text changeText = new Text();
                changeText.setText(change);
                changeText.setFill(Color.GREEN);
                historyItem.addAll(new CodeHistory(date, price, changeText));
                if (i == 0){
                    sd.setTrendSignal("U");
                } else sd.setTrendSignal(sd.getTrendSignal() + "-U");

            }else{
                Text changeText = new Text();
                changeText.setText(change);
                changeText.setFill(Color.RED);
                historyItem.addAll(new CodeHistory(date, price, changeText));
                if (i == 0){
                    sd.setTrendSignal("D");
                } else sd.setTrendSignal(sd.getTrendSignal() +"-D");
            }

            tblCodeHistory.refresh();
            tblSurfList.refresh();

            currentRow = tempt;
            nextRow = currentRow.nextElementSibling();
            tempt = nextRow;
        }

    }

    @FXML
    public void updateItem(ActionEvent actionEvent) {
        //Calculate new Up cut Price and Down cut Price
        double boughtPrice,upRate, downRate, upCutPrice = 0, downCutPrice = 0;

        String upRateString = txtUpcutRate.getText().trim();
        upRateString = upRateString.substring(0, upRateString.length() - 2);
        upRate = Double.parseDouble(upRateString);

        String dRateString = txtDowncutRate.getText().trim();
        dRateString = dRateString.substring(0, dRateString.length() - 2);
        downRate = Double.parseDouble(dRateString);
        boughtPrice = Double.parseDouble(txtBoughtPrice.getText());

        if (boughtPrice > 0){
            upCutPrice = Math.round(boughtPrice * (1 + upRate)*100);
            downCutPrice = Math.round(boughtPrice * (1 - downRate)*100);
        }

        //Add new data to table view
        SurfData clickedItem = (SurfData) tblSurfList.getSelectionModel().getSelectedItem();
        clickedItem.setType(txtType.getText());
        clickedItem.setCode(txtCode.getText().toUpperCase());
        clickedItem.setTrendSignal(txtTrendSignal.getText());
        clickedItem.setReferPrice(txtReferPrice.getText());
        clickedItem.setBoughtPrice(txtBoughtPrice.getText());
        clickedItem.setRate(txtUpcutRate.getText());
        clickedItem.setUpcutPrice(String.valueOf((upCutPrice/100)));
        clickedItem.setDRate(txtDowncutRate.getText());
        clickedItem.setDowncutPrice(String.valueOf(downCutPrice/100));
        clickedItem.setStyle(txtStyle.getText());
        clickedItem.setRemark(txtRemark.getText());

        //Clear text fields
        txtType.setText("");
        txtCode.setText("");
        txtTrendSignal.setText("");
        txtUpcutRate.setText("");
        txtReferPrice.setText("");
        txtBoughtPrice.setText("");
        txtUpcutRate.setText("");
        txtDowncutRate.setText("");
        txtStyle.setText("");
        txtRemark.setText("");

        tblSurfList.refresh();

    }

    public void clickItem(MouseEvent mouseEvent) {
        //When click 1 row, auto show its data to text fields
        SurfData clickedItem = (SurfData) tblSurfList.getSelectionModel().getSelectedItem();
        if (clickedItem != null) {
            txtCode.setText(clickedItem.getCode());
            txtType.setText(clickedItem.getType());
            txtTrendSignal.setText(clickedItem.getTrendSignal());
            txtReferPrice.setText(clickedItem.getReferPrice());
            txtBoughtPrice.setText(clickedItem.getBoughtPrice());
            txtUpcutRate.setText(clickedItem.getRate());
            txtDowncutRate.setText(clickedItem.getDRate());
            txtStyle.setText(clickedItem.getStyle());
            txtRemark.setText(clickedItem.getRemark());
        }
    }


    public void setWebView(){

    }
}
