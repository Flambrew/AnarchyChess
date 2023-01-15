package src.graphics;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {

    // public final Color MENU = new Color(.318, .337, .384, 1);
    // public final Color TEXT = new Color(.933, 1, 1, 1);
    // public final Color LIGHT = new Color(.8, .655, 0, 1);
    // public final Color DARK = new Color(.514, .404, .141, 1);

    public void initialize() {
        System.out.println("MenuInit");
    }

    public void switchToGame(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        GameController controller = loader.getController();

        stage.setScene(scene);
        scene.getStylesheets().add(this.getClass().getResource("Game.css").toExternalForm());
        stage.show();
    }

    public void switchToSettings(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Settings.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        SettingsController controller = loader.getController();

        stage.setScene(scene);
        scene.getStylesheets().add(this.getClass().getResource("Settings.css").toExternalForm());
        stage.show();
    }
}
