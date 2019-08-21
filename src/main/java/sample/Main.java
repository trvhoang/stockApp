package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class Main extends Application {
    @Override
    public void start(Stage surfStage) throws Exception{
        // surf view
        surfStage.setTitle("Surf View");
        Pane surfPane = (Pane) FXMLLoader.load(getClass().getClassLoader().getResource("/surf.fxml"));
        Scene scene = new Scene(surfPane);

        surfStage.setScene(scene);
        surfStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
