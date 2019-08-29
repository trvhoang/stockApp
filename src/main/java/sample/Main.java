package sample;

import core.SurfData;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.scene.*;



public class Main extends Application {
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
    @Override
    public void start(Stage surfStage) throws Exception{
        // surf view

        surfStage.setTitle("Surf View");
        Pane surfPane = (Pane) FXMLLoader.load(getClass().getClassLoader().getResource("surf.fxml"));
        Scene scene = new Scene(surfPane);

        surfStage.setScene(scene);
        surfStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
