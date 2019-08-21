package sample;
import core.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;


import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


public class SController {
    @FXML
    private Button btnAdd;
    @FXML
    private TableView tblSurfList;
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
//    @FXML
//    private TableColumn TypeCol;
//    @FXML
//    private TableColumn CodeCol;
//    @FXML
//    private TableColumn TrendSignalCol;
//    @FXML
//    private TableColumn ReferPriceCol;
//    @FXML
//    private TableColumn BoughtPriceCol;
//    @FXML
//    private TableColumn RateCol;
//    @FXML
//    private TableColumn UpcutPriceCol;
//    @FXML
//    private TableColumn DowncutPriceCol;
//    @FXML
//    private TableColumn StyleCol;
//    @FXML
//    private TableColumn RemarkCol;

    @FXML
    protected void addItem(ActionEvent event){
        ObservableList<SurfData> data = tblSurfList.getItems();
        data.add(new SurfData(txtType.getText(), txtCode.getText(), txtTrendSignal.getText(), txtReferPrice.getText(),
                                txtRate.getText(), txtBoughtPrice.getText(), txtUpcutPrice.getText(), txtDowncutPrice.getText(),
                                txtStyle.getText(), txtRemark.getText()));

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

}
