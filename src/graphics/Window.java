package src.graphics;

import javafx.application.Application;
import javafx.stage.Stage;

public class Window extends Application {

    public void start(Stage mainStage) {
        mainStage.setTitle("My Window");
        mainStage.setWidth(1280);
        mainStage.setHeight(720);
        mainStage.setResizable(false);
        mainStage.show();
        
    }
}
