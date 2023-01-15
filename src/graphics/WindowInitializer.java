package src.graphics;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            MenuController controller = loader.getController();

            stage.setScene(scene);
            scene.getStylesheets().add(css);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
