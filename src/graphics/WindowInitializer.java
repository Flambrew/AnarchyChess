package src.graphics;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class WindowInitializer extends Application {

    private String fxml;
    private String css;
    private Image icon;

    public void init() throws Exception {
        fxml = "Menu.fxml";
        css = this.getClass().getResource("Menu.css").toExternalForm();
        icon = new Image("assets\\Logo.png");
    }

    public void start(Stage stage) {
        stage.setTitle("AnarchyChess");
        stage.getIcons().add(icon);

        try {
            Parent root = new FXMLLoader(getClass().getResource(fxml)).load();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            scene.getStylesheets().add(css);
            stage.show();

            stage.setOnCloseRequest(event -> {
                event.consume();
                exit(stage);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exit(Stage stage) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Crush PIPI");
        alert.setHeaderText("You are about to crush your PIPI!");
        alert.setContentText("This will make you biggest looser!");
        ImageView imageView = new ImageView("assets\\Logo.png");
        imageView.setFitHeight(32);
        imageView.setFitWidth(32);
        alert.setGraphic(imageView);

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("Exiting...");
            stage.close();
        }
    }

}
