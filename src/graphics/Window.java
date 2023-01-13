package src.graphics;

import javafx.application.Application;
import javafx.stage.Stage;

public class Window extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage mainStage) {
        mainStage.setTitle("My Window");
        mainStage.show();
    }
}
