package src.graphics;

import java.util.stream.IntStream;

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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import src.graphics.scenes.MainScene;
import src.graphics.scenes.OverlayScene;
import src.utils.Vector2;

public class Window extends Application {

    private static final Color BACK = new Color(.125, .145, .192, 1);
    private static final Color MENU = new Color(.318, .337, .384, 1);
    private static final Color TEXT = new Color(.933, 1, 1, 1);
    private static final Color LIGHT = new Color(.8, .655, 0, 1);
    private static final Color DARK = new Color(.514, .404, .141, 1);

    private static MainScene activeScene = MainScene.MAIN_MENU;
    private static OverlayScene overlay = OverlayScene.NONE;

    private static Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
    private static Vector2 windowSize = new Vector2(1280, 720);

    public static void setWindowSize(Vector2 windowSize) {
        Window.windowSize = windowSize;
    }

    public void start(Stage stage) {
        stage.setTitle("Window");

        stage.setX((screenSize.getWidth() - windowSize.X) / 2);
        stage.setY((screenSize.getHeight() - windowSize.Y) / 2);
        stage.setMinWidth(200);
        stage.setMinWidth(200);

        stage.setScene(menuScene(stage));
        stage.show();
    }

    private Scene menuScene(Stage stage) {
        Pane root = new Pane();
        Canvas canvas = new Canvas(windowSize.X, windowSize.Y);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Scene menu = new Scene(root, windowSize.X, windowSize.Y);
        root.getChildren().add(canvas);

        Button[] buttons = new Button[] {
                new Button("Singleplayer"),
                new Button("Multiplayer"),
                new Button("Settings")
        };
        for (Button button : buttons) {
            root.getChildren().add(button);
            button.setBackground(new Background(new BackgroundFill(MENU, new CornerRadii(25), null)));
            button.setTextFill(TEXT);
            button.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        }
        buttons[0].setOnAction(e -> {
            stage.setScene(gameScene(stage));
        });
        buttons[1].setOnAction(e -> {
            stage.setScene(gameScene(stage));
        });
        buttons[2].setOnAction(e -> {
            overlay = OverlayScene.SETTINGS;
        });

        stage.widthProperty().addListener((observable, oldValue, newValue) -> {
            windowSize = new Vector2(newValue.intValue(), windowSize.Y);
            canvas.setWidth(windowSize.X);
            drawMenu(gc);

            updateButtonX(buttons, new Vector2[] {
                    new Vector2((int) (windowSize.X * .15), (int) (windowSize.X * .2)),
                    new Vector2((int) (windowSize.X * .40), (int) (windowSize.X * .2)),
                    new Vector2((int) (windowSize.X * .65), (int) (windowSize.X * .2))
            });
        });
        stage.heightProperty().addListener((observable, oldValue, newValue) -> {
            windowSize = new Vector2(windowSize.X, newValue.intValue());
            canvas.setHeight(windowSize.Y);
            drawMenu(gc);

            updateButtonY(buttons, new Vector2[] {
                    new Vector2((int) (windowSize.Y * .75), (int) (windowSize.Y * .125)),
                    new Vector2((int) (windowSize.Y * .75), (int) (windowSize.Y * .125)),
                    new Vector2((int) (windowSize.Y * .75), (int) (windowSize.Y * .125))
            });
        });

        return menu;
    }

    private Scene gameScene(Stage stage) {
        Pane root = new Pane();
        Canvas canvas = new Canvas(windowSize.X, windowSize.Y);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Scene game = new Scene(root, windowSize.X, windowSize.Y);
        root.getChildren().add(canvas);

        Button[] buttons = new Button[64];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button();
            root.getChildren().add(buttons[i]);
            buttons[i].setBackground(new Background(new BackgroundFill(i % 2 == 0 ? LIGHT : DARK, null, null)));
            buttons[i].setOnAction(e -> System.out.println("yo mama"));
        }

        stage.widthProperty().addListener((observable, oldValue, newValue) -> {
            windowSize = new Vector2(newValue.intValue(), windowSize.Y);
            canvas.setWidth(windowSize.X);
            drawGame(gc);

            updateButtonX(buttons, IntStream.range(0, buttons.length).mapToObj(i -> new Vector2(0, 0)).toArray(Vector2[]::new));

        });
        stage.heightProperty().addListener((observable, oldValue, newValue) -> {
            windowSize = new Vector2(windowSize.X, newValue.intValue());
            canvas.setHeight(windowSize.Y);
            drawGame(gc);

            for (Button button : buttons)
                updateButtonY(new Button[] { button }, new Vector2[] { new Vector2(100, 100) });
        });

        return game;
    }

    private void drawMenu(GraphicsContext gc) {
        gc.clearRect(0, 0, windowSize.X, windowSize.Y);
        gc.setFill(BACK);
        gc.fillRect(0, 0, windowSize.X, windowSize.Y);
        gc.setFill(MENU);
        gc.fillRoundRect(windowSize.X * .1, windowSize.Y * .125, windowSize.X * .8, windowSize.Y * .5, 50, 50);
    }

    private void drawGame(GraphicsContext gc) {
        gc.clearRect(0, 0, windowSize.X, windowSize.Y);
    }

    private void updateButtonX(Button[] buttons, Vector2[] transforms) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setLayoutX(transforms[i].X);
            buttons[i].setPrefWidth(transforms[i].Y);
        }
    }

    private void updateButtonY(Button[] buttons, Vector2[] transforms) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setLayoutY(transforms[i].X);
            buttons[i].setPrefHeight(transforms[i].Y);
        }
    }
}
