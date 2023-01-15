package src.graphics;

import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import src.graphics.graphicutils.Colors;
import src.graphics.graphicutils.Fonts;
import src.utils.Vector2;

public class Window extends Application {

    private static Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
    private static Vector2 windowSize = new Vector2(1280, 720);

    public static void setWindowSize(Vector2 windowSize) {
        Window.windowSize = windowSize;
    }

    public void start(Stage stage) {
        stage.setTitle("Window");

        stage.setX((screenSize.getWidth() - windowSize.X) / 2);
        stage.setY((screenSize.getHeight() - windowSize.Y) / 2);
        stage.setMinWidth(800);
        stage.setMinHeight(500);

        stage.setResizable(true);

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
            button.setBackground(new Background(new BackgroundFill(Colors.MENU, new CornerRadii(25), null)));
            button.setTextFill(Colors.TEXT);
            button.setFont(Fonts.ARIAL_BOLD);
        }
        buttons[0].setOnAction(e -> stage.setScene(gameScene(stage)));
        buttons[1].setOnAction(e -> stage.setScene(gameScene(stage)));
        buttons[2].setOnAction(e -> stage.setScene(settingsScene(stage)));

        stage.widthProperty().addListener((observable, oldValue, newValue) -> {
            windowSize = new Vector2(newValue.intValue(), windowSize.Y);
            canvas.setWidth(windowSize.X);
            Draw.menu(gc, windowSize);

            ResizeButton.x(buttons, new Vector2[] {
                    new Vector2((int) (windowSize.X * .15), (int) (windowSize.X * .2)),
                    new Vector2((int) (windowSize.X * .40), (int) (windowSize.X * .2)),
                    new Vector2((int) (windowSize.X * .65), (int) (windowSize.X * .2))
            });
        });
        stage.heightProperty().addListener((observable, oldValue, newValue) -> {
            windowSize = new Vector2(windowSize.X, newValue.intValue());
            canvas.setHeight(windowSize.Y);
            Draw.menu(gc, windowSize);

            ResizeButton.y(buttons, new Vector2[] {
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
            buttons[i].setBackground(
                    new Background(
                            new BackgroundFill(i % 2 == 0 ^ i / 8 % 2 == 1 ? Colors.DARK : Colors.LIGHT, null, null)));
            buttons[i].setOnAction(e -> System.out.println("yo mama")); // TODO: make button inputs actually do stuff
        }

        stage.widthProperty().addListener((observable, oldValue, newValue) -> {
            windowSize = new Vector2(newValue.intValue(), windowSize.Y);
            canvas.setWidth(windowSize.X);
            Draw.game(gc, windowSize);

            ResizeButton.x(buttons, IntStream.range(0, buttons.length).mapToObj(i -> new Vector2(
                    (windowSize.X - Math.min(windowSize.X - 400, windowSize.Y - 100)) / 2
                            + i % 8 * (Math.min(windowSize.X - 400, windowSize.Y - 100) / 8),
                    Math.min(windowSize.X - 400, windowSize.Y - 100) / 8))
                    .toArray(Vector2[]::new));

        });
        stage.heightProperty().addListener((observable, oldValue, newValue) -> {
            windowSize = new Vector2(windowSize.X, newValue.intValue());
            canvas.setHeight(windowSize.Y);
            Draw.game(gc, windowSize);

            ResizeButton.y(buttons, IntStream.range(0, buttons.length).mapToObj(i -> new Vector2(
                    (windowSize.Y - Math.min(windowSize.X - 400, windowSize.Y - 100)) / 2
                            + i / 8 * (Math.min(windowSize.X - 400, windowSize.Y - 100) / 8) ,
                    Math.min(windowSize.X - 400, windowSize.Y - 100) / 8))
                    .toArray(Vector2[]::new));
        });

        return game;
    }

    private Scene settingsScene(Stage stage) {
        Pane root = new Pane();
        Canvas canvas = new Canvas(windowSize.X, windowSize.Y);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Scene settings = new Scene(root, windowSize.X, windowSize.Y);
        root.getChildren().add(canvas);

        Button[] buttons = new Button[] {

        };
        // for (Button button : buttons) {
        // root.getChildren().add(button);
        // button.setBackground(new Background(new BackgroundFill(Colors.MENU, new
        // CornerRadii(25), null)));
        // button.setTextFill(Colors.TEXT);
        // button.setFont(Fonts.ARIAL_BOLD);
        // }
        // buttons[0].setOnAction(e -> System.out.println("guh")); // TODO: settings

        stage.widthProperty().addListener((observable, oldValue, newValue) -> {
            windowSize = new Vector2(newValue.intValue(), windowSize.Y);
            canvas.setWidth(windowSize.X);
            Draw.settings(gc, windowSize);

            ResizeButton.x(buttons, new Vector2[] {

            });
        });
        stage.heightProperty().addListener((observable, oldValue, newValue) -> {
            windowSize = new Vector2(windowSize.X, newValue.intValue());
            canvas.setHeight(windowSize.Y);
            Draw.settings(gc, windowSize);

            ResizeButton.y(buttons, new Vector2[] {

            });
        });

        return settings;
    }

}
