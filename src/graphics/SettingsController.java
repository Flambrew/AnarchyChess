package src.graphics;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;
import src.main.MainLoop;

public class SettingsController implements Initializable {

    @FXML
    private ChoiceBox<String> selectResolution;
    private String[] resolutions = { "640x360", "1280x720", "1920x1080", "2560x1440", "3840x2160" };

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("SettingInit");
        selectResolution.getItems().addAll(resolutions);
        selectResolution.setOnAction(this::selectResolution);
    }

    public void toggleAnarchy() {
        MainLoop.setAnarchy(!MainLoop.isAnarchy());
        System.out.println("Anarchy has been set to: " + MainLoop.isAnarchy());
    }

    public void selectResolution(ActionEvent e) { // TODO SCALE OBJECTS WITH SCREEN
        Window window = selectResolution.getScene().getWindow();
        Rectangle2D monitor = Screen.getPrimary().getVisualBounds();
        switch (selectResolution.getValue()) {
            case "640x360":
                window.setWidth(640);
                window.setHeight(360);
                break;
            case "1280x720":
                window.setWidth(1280);
                window.setHeight(720);
                break;
            case "1920x1080":
                window.setWidth(1920);
                window.setHeight(1080);
                break;
            case "2560x1440":
                window.setWidth(2560);
                window.setHeight(1440);
                break;
            case "3840x2160":
                window.setWidth(3840);
                window.setHeight(2160);
                break;
        }
        window.setX((monitor.getWidth() - window.getWidth()) / 2);
        window.setY((monitor.getHeight() - window.getHeight()) / 2);
    }

    public void switchToMenu(ActionEvent e) throws IOException {
        Parent root = new FXMLLoader(getClass().getResource("Menu.fxml")).load();
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
