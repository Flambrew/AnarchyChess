package src.graphics;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import src.utils.Vector2;

public class Window extends Application {

    // private Vector2 stageDimensions = new Vector2(1280, 720);

    public void start(Stage stage) {

        Parent root;
        try {


            root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);


        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

}
