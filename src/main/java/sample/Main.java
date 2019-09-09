package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class Main extends Application {
    @FXML
    private Tab tbStock;

    @Override
    public void start(Stage surfStage) throws Exception{
        // surf view
        surfStage.setTitle("Main Menu");
        Pane surfPane = (Pane) FXMLLoader.load(getClass().getClassLoader().getResource("main-menu.fxml"));
        if (tbStock.isSelected()){
            WebView wv = new WebView();
            wv.getEngine().load("https://vn.tradingview.com/chart/");
            surfPane.getChildren().add(wv);

        }
            Scene scene = new Scene(surfPane);

            surfStage.setScene(scene);
//            surfStage.setFullScreen(true);
            surfStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
