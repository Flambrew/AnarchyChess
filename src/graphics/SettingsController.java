package src.graphics;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SettingsController {

    // public final Color MENU = new Color(.318, .337, .384, 1);
    // public final Color TEXT = new Color(.933, 1, 1, 1);
    // public final Color LIGHT = new Color(.8, .655, 0, 1);
    // public final Color DARK = new Color(.514, .404, .141, 1);

    public void initialize() {
        System.out.println("SettingInit");
    }

    public void switchToMenu(ActionEvent e) throws IOException {
        Parent root = new FXMLLoader(getClass().getResource("Menu.fxml")).load();
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
