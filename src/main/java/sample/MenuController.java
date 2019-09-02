package sample;
import core.*;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Callback;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import java.io.IOException;



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
    private TextField txtRate;
    @FXML
    private TextField txtReferPrice;
    @FXML
    private TextField txtBoughtPrice;
    @FXML
    private TextField txtUpcutPrice;
    @FXML
    private TextField txtDowncutPrice;
    @FXML
    private TextField txtStyle;
    @FXML
    private TextField txtRemark;
    @FXML
    private TableColumn<CodeHistory, String> ChangeCol;

    @FXML
    protected void addItem(ActionEvent event){
        ObservableList<SurfData> data = tblSurfList.getItems();
        float boughtPrice,rate, upCutPrice = 0, downCutPrice = 0;
        rate = Float.parseFloat(txtRate.getText());
        boughtPrice = Float.parseFloat(txtBoughtPrice.getText());

        if (boughtPrice > 0){
            upCutPrice = Math.round(boughtPrice * rate);
            downCutPrice = Math.round(boughtPrice * 0.93);
        }

        data.add(new SurfData(txtType.getText().trim(), txtCode.getText().trim().toUpperCase(), txtTrendSignal.getText().trim(), txtReferPrice.getText().trim(),
                                txtRate.getText().trim(), txtBoughtPrice.getText().trim(), String.valueOf(upCutPrice), String.valueOf(downCutPrice),
                                txtStyle.getText().trim(), txtRemark.getText().trim()));

        txtType.setText("");
        txtCode.setText("");
        txtTrendSignal.setText("");
        txtRate.setText("");
        txtReferPrice.setText("");
        txtBoughtPrice.setText("");
        txtUpcutPrice.setText("");
        txtDowncutPrice.setText("");
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
        txtRate.setText("");
        txtReferPrice.setText("");
        txtBoughtPrice.setText("");
        txtUpcutPrice.setText("");
        txtDowncutPrice.setText("");
        txtStyle.setText("");
        txtRemark.setText("");
    }

    @FXML
    protected void viewHistory(ActionEvent event) throws IOException {
        System.out.println("Click btn");
        SurfData clickedItem = tblSurfList.getSelectionModel().getSelectedItem();
        String url = "http://s.cafef.vn/Lich-su-giao-dich-"+clickedItem.getCode()+"-1.chn";

        Element currentRow = Jsoup.connect(url)
                                            .get()
                                            .body()
                                            .getElementById("ctl00_ContentPlaceHolder1_ctl03_rptData2_ctl01_itemTR");

        Element nextRow = currentRow.nextElementSibling();
        Element tempt = nextRow;

        for(int i = 0; i <8; i++){
            String date = currentRow.selectFirst("> td.Item_DateItem").text().trim();
            String price = currentRow.selectFirst("> td:nth-child(3)").text().trim();
            String change = currentRow.selectFirst("> td.Item_ChangePrice").text().trim();

            ObservableList<CodeHistory> historyItem = tblCodeHistory.getItems();

//            historyItem.addAll(new CodeHistory(date, price, change));

            Float check = Float.parseFloat(change.substring(0,5));

            if(check >= 0){
                Text changeText = new Text();
                changeText.setText(change);
                changeText.setFill(Color.GREEN);
                historyItem.addAll(new CodeHistory(date, price, changeText));
            }else{
                Text changeText = new Text();
                changeText.setText(change);
                changeText.setFill(Color.RED);
                historyItem.addAll(new CodeHistory(date, price, changeText));
            }

            tblCodeHistory.refresh();

            currentRow = tempt;
            nextRow = currentRow.nextElementSibling();
            tempt = nextRow;
        }

    }

    @FXML
    public void updateItem(ActionEvent actionEvent) {
        SurfData clickedItem = (SurfData) tblSurfList.getSelectionModel().getSelectedItem();
        clickedItem.setType(txtType.getText());
        clickedItem.setCode(txtCode.getText());
        clickedItem.setTrendSignal(txtTrendSignal.getText());
        clickedItem.setReferPrice(txtReferPrice.getText());
        clickedItem.setBoughtPrice(txtBoughtPrice.getText());
        clickedItem.setRate(txtRate.getText());
        clickedItem.setUpcutPrice(txtUpcutPrice.getText());
        clickedItem.setDowncutPrice(txtDowncutPrice.getText());
        clickedItem.setStyle(txtStyle.getText());
        clickedItem.setRemark(txtRemark.getText());

        txtType.setText("");
        txtCode.setText("");
        txtTrendSignal.setText("");
        txtRate.setText("");
        txtReferPrice.setText("");
        txtBoughtPrice.setText("");
        txtUpcutPrice.setText("");
        txtDowncutPrice.setText("");
        txtStyle.setText("");
        txtRemark.setText("");

        tblSurfList.refresh();

    }

    public void clickItem(MouseEvent mouseEvent) {
        SurfData clickedItem = (SurfData) tblSurfList.getSelectionModel().getSelectedItem();
        if (clickedItem != null) {
            txtCode.setText(clickedItem.getCode());
            txtType.setText(clickedItem.getType());
            txtTrendSignal.setText(clickedItem.getTrendSignal());
            txtReferPrice.setText(clickedItem.getReferPrice());
            txtBoughtPrice.setText(clickedItem.getBoughtPrice());
            txtRate.setText(clickedItem.getRate());
            txtUpcutPrice.setText(clickedItem.getUpcutPrice());
            txtDowncutPrice.setText(clickedItem.getDowncutPrice());
            txtStyle.setText(clickedItem.getStyle());
            txtRemark.setText(clickedItem.getRemark());
        }
    }


}
