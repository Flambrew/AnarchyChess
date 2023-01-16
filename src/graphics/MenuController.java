package src.graphics;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController {

    // public final Color MENU = new Color(.318, .337, .384, 1);
    // public final Color TEXT = new Color(.933, 1, 1, 1);
    // public final Color LIGHT = new Color(.8, .655, 0, 1);
    // public final Color DARK = new Color(.514, .404, .141, 1);

    @FXML
    private Button exitbutton;
    @FXML
    private AnchorPane scenePane;

    Stage stage;

    public void exit(ActionEvent e) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Crush PIPI");
        alert.setHeaderText("You are about to crush your PIPI!");
        alert.setContentText("This will make you biggest looser!");
        ImageView imageView = new ImageView("assets\\Logo.png");
        imageView.setFitHeight(32);
        imageView.setFitWidth(32);
        alert.setGraphic(imageView);

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("Exiting...");
            stage.close();
        }
    }

    public void initialize() {
        System.out.println("MenuInit");
    }

    public void switchToGame(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        // GameController controller = loader.getController();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSettings(ActionEvent e) throws IOException {
        Parent root = new FXMLLoader(getClass().getResource("Settings.fxml")).load();
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAchievements(ActionEvent e) throws IOException {
        Parent root = new FXMLLoader(getClass().getResource("Achievements.fxml")).load();
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
