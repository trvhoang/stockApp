package sample;
import core.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;


import javafx.scene.control.*;


public class SController {
    @FXML
    private TableView tblSurfList;
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
    private TextField txtUpcutPrice;
    @FXML
    private TextField txtDowncutPrice;
    @FXML
    private TextField txtStyle;
    @FXML
    private TextField txtRemark;
    @FXML
    private TableColumn TypeCol;
    @FXML
    private TableColumn CodeCol;
    @FXML
    private TableColumn TrendSignalCol;
    @FXML
    private TableColumn ReferPriceCol;
    @FXML
    private TableColumn BoughtPriceCol;
    @FXML
    private TableColumn RateCol;
    @FXML
    private TableColumn UpcutPriceCol;
    @FXML
    private TableColumn DowncutPriceCol;
    @FXML
    private TableColumn StyleCol;
    @FXML
    private TableColumn RemarkCol;



    TableView<SurfData> table = new TableView<SurfData>();

    public void AddSurf(ActionEvent actionEvent) {
        SurfData item = new SurfData(txtType.getText(),txtCode.getText(), txtTrendSignal.getText(), txtReferPrice.getText(), txtBoughtPrice.getText(),
                                     txtUpcutPrice.getText(), txtDowncutPrice.getText(), txtStyle.getText(), txtRemark.getText());
        table.getItems().add(item);

    }
}
