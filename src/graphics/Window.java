package src.graphics;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import src.game.constructs.Vector2;

public class Window extends Application {

    private static final Color BACKGROUND = new Color(.125, .145, .192, 1);
    private static final Color MENU = new Color(0.318, 0.337, 0.384, 1);

    private static Vector2 windowSize = new Vector2(1280, 720);

    private Stage primaryStage;

    public static void setWindowSize(Vector2 windowSize) {
        Window.windowSize = windowSize;
    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        final Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        primaryStage.setTitle("Window");

        Scene menu = menuScene();
        Scene game = gameScene();

        primaryStage.setX((screenSize.getWidth() - windowSize.X) / 2);
        primaryStage.setY((screenSize.getHeight() - windowSize.Y) / 2);

        primaryStage.setScene(menu);
        primaryStage.show();
    }

    private Scene menuScene() {
        StackPane root = new StackPane();
        Canvas canvas = new Canvas(windowSize.X, windowSize.Y);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Scene menu = new Scene(root, windowSize.X, windowSize.Y);
        root.getChildren().add(canvas);

        gc.setFill(BACKGROUND);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.setFill(MENU);
        gc.fillRoundRect(windowSize.X * .2, windowSize.Y * .125, windowSize.X * .6, windowSize.Y * .5, 50, 50);
        gc.fillRoundRect(windowSize.X * .245, windowSize.Y * .75, windowSize.X * .14, windowSize.Y * .125, 25, 25);
        gc.fillRoundRect(windowSize.X * .430, windowSize.Y * .75, windowSize.X * .14, windowSize.Y * .125, 25, 25);
        gc.fillRoundRect(windowSize.X * .605, windowSize.Y * .75, windowSize.X * .14, windowSize.Y * .125, 25, 25);

        return menu;
    }

    private Scene gameScene() {
        Scene game = new Scene(new StackPane(), windowSize.X, windowSize.Y);

        return game;
    }
}
