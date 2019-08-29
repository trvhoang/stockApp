package sample;
import core.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;
import java.util.Observable;


public class SController {

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
    protected void addItem(ActionEvent event){
        ObservableList<SurfData> data = tblSurfList.getItems();
        data.add(new SurfData(txtType.getText().trim(), txtCode.getText().trim(), txtTrendSignal.getText().trim(), txtReferPrice.getText().trim(),
                                txtRate.getText().trim(), txtBoughtPrice.getText().trim(), txtUpcutPrice.getText().trim(), txtDowncutPrice.getText().trim(),
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
        SurfData clickedItem = (SurfData) tblSurfList.getSelectionModel().getSelectedItem();
        String url = "http://s.cafef.vn/Lich-su-giao-dich-"+clickedItem.getCode()+"-1.chn";

        Element currentRow = Jsoup.connect(url)
                                            .get()
                                            .body()
                                            .getElementById("ctl00_ContentPlaceHolder1_ctl03_rptData2_ctl01_itemTR");

        Element nextRow = currentRow.nextElementSibling();

        Element tempt = nextRow;

//        ObservableList<CodeHistory> historyItem = tblCodeHistory.getItems();
//        System.out.println("history item: "+ historyItem);

        System.out.println("Get history successful ");
        tblCodeHistory.refresh();
        for(int i = 0; i <7; i++){
            String date = currentRow.selectFirst("> td.Item_DateItem").text().trim();
            String price = currentRow.selectFirst("> td:nth-child(3)").text().trim();

//            ObservableList<CodeHistory> historyItem = tblCodeHistory.getItems();
//            System.out.println("history item: "+ historyItem);

            tblCodeHistory.getItems().add(new CodeHistory(date, price));
            System.out.println(date + "  " + price);

            System.out.println("history item: "+ tblCodeHistory.getItems().toString());
            System.out.println("Add data successful: " + date + " - " + price);
            currentRow = tempt;
            tempt = nextRow.nextElementSibling();
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
