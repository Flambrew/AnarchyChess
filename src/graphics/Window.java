package src.graphics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import src.graphics.scenes.MainScene;
import src.graphics.scenes.OverlayScene;
import src.utils.Vector2;
import src.utils.Vector4;

public class Window extends Application {

    private static MainScene activeScene = MainScene.MAIN_MENU;
    private static OverlayScene overlay = OverlayScene.NONE;

    private static final Color BACKGROUND = new Color(.125, .145, .192, 1);
    private static final Color MENU = new Color(0.318, 0.337, 0.384, 1);

    private static Vector2 windowSize = new Vector2(1280, 720);

    public static void setWindowSize(Vector2 windowSize) {
        Window.windowSize = windowSize;
    }

    public void start(Stage primaryStage) {
        final Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        primaryStage.setTitle("Window");

        Scene menu = menuScene(primaryStage);
        Scene game = gameScene(primaryStage);

        primaryStage.setX((screenSize.getWidth() - windowSize.X) / 2);
        primaryStage.setY((screenSize.getHeight() - windowSize.Y) / 2);

        switch (activeScene) {
            case MAIN_MENU:
                primaryStage.setScene(menu);
                break;
            case GAME:
                primaryStage.setScene(game);
                break;
            default:
        }
        primaryStage.show();
    }

    private Scene menuScene(Stage stage) {
        Pane root = new Pane();
        Canvas canvas = new Canvas(windowSize.X, windowSize.Y);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Scene menu = new Scene(root, windowSize.X, windowSize.Y);
        root.getChildren().add(canvas);

        final Vector4[] buttonTransforms = new Vector4[] {
                new Vector4(windowSize.X * .245, windowSize.Y * .75, windowSize.X * .14, windowSize.Y * .125),
                new Vector4(windowSize.X * .430, windowSize.Y * .75, windowSize.X * .14, windowSize.Y * .125),
                new Vector4(windowSize.X * .605, windowSize.Y * .75, windowSize.X * .14, windowSize.Y * .125),
        };
        final Button[] buttons = new Button[] {
                new Button("Singleplayer"),
                new Button("Multiplayer"),
                new Button("Settings")
        };
        for (Button button : buttons) {
            root.getChildren().add(button);
            button.setBackground(new Background(new BackgroundFill(MENU, new CornerRadii(25), Insets.EMPTY)));
            button.setOnAction(e -> System.out.println("button momer"));
        }

        stage.widthProperty().addListener((observable, oldValue, newValue) -> {
            windowSize = new Vector2(newValue.intValue(), windowSize.Y);
            canvas.setWidth(windowSize.X);
            buttonTransform(buttons, buttonTransforms);

            drawMenu(gc);
        });

        stage.heightProperty().addListener((observable, oldValue, newValue) -> {
            windowSize = new Vector2(windowSize.X, newValue.intValue());
            canvas.setHeight(windowSize.Y);
            buttonTransform(buttons, buttonTransforms);
            
            drawMenu(gc);
        });

        return menu;
    }

    private void drawMenu(GraphicsContext gc) {
        gc.clearRect(0, 0, windowSize.X, windowSize.Y);
        gc.setFill(BACKGROUND);
        gc.fillRect(0, 0, windowSize.X, windowSize.Y);
    }

    private Scene gameScene(Stage stage) {
        // StackPane root = new StackPane();
        // Canvas canvas = new Canvas(windowSize.X, windowSize.Y);
        // GraphicsContext gc = canvas.getGraphicsContext2D();
        // Scene game = new Scene(root, windowSize.X, windowSize.Y);
        // root.getChildren().add(canvas);

        // stage.widthProperty().addListener((observable, oldValue, newValue) -> {
        // windowSize = new Vector2(newValue.intValue(), windowSize.Y);
        // canvas.setWidth(windowSize.X);
        // gc.clearRect(0, 0, windowSize.X, windowSize.Y);
        // drawGame(gc);
        // });
        // stage.heightProperty().addListener((observable, oldValue, newValue) -> {
        // windowSize = new Vector2(windowSize.X, newValue.intValue());
        // canvas.setHeight(windowSize.Y);
        // gc.clearRect(0, 0, windowSize.X, windowSize.Y);
        // drawGame(gc);
        // });

        // return game;
        return null;
    }

    // private void drawGame(GraphicsContext gc) {}

    private void buttonTransform(Button[] buttons, Vector4[] transforms) {
        for (int i = 0; i < transforms.length; i++) {
            buttons[i].setLayoutX(transforms[i].w);
            buttons[i].setLayoutY(transforms[i].x);
            buttons[i].setPrefWidth(transforms[i].y);
            buttons[i].setPrefHeight(transforms[i].z);
        }
    }
}
