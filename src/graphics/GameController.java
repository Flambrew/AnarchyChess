package src.graphics;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameController {

    public void initialize() {
        System.out.println("GameInit");
    }

    public void switchToMenu(ActionEvent e) throws IOException {
        Parent root = new FXMLLoader(getClass().getResource("Menu.fxml")).load();
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
