package sample;

import com.sun.deploy.Environment;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserCore;
import com.teamdev.jxbrowser.chromium.internal.Environment;
import com.teamdev.jxbrowser.chromium.javafx.BrowserView;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void init() throws Exception{
        if()
    }

    @Override
    public void start(Stage surfStage) throws Exception{
        // surf view
        surfStage.setTitle("Main Menu");
        Pane surfPane = FXMLLoader.load(getClass().getClassLoader().getResource("main-menu.fxml"));

        Scene scene = new Scene(surfPane);
        surfStage.setScene(scene);
        surfStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
