package src.graphics;

import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import src.graphics.graphicutils.Colors;
import src.graphics.graphicutils.Fonts;
import src.graphics.graphicutils.Offset;
import src.utils.Vector2;

public class Window extends Application {

    private static Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
    private static Vector2 windowSize = new Vector2(1280, 720);

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

            Resize.buttonX(buttons, new Vector2[] {
                    new Vector2((int) (windowSize.X * .15), (int) (windowSize.X * .2)),
                    new Vector2((int) (windowSize.X * .40), (int) (windowSize.X * .2)),
                    new Vector2((int) (windowSize.X * .65), (int) (windowSize.X * .2))
            });
        });
        stage.heightProperty().addListener((observable, oldValue, newValue) -> {
            windowSize = new Vector2(windowSize.X, newValue.intValue());
            canvas.setHeight(windowSize.Y);
            Draw.menu(gc, windowSize);

            Resize.buttonY(buttons, new Vector2[] {
                    new Vector2((int) (windowSize.Y * .75), (int) (windowSize.Y * .125)),
                    new Vector2((int) (windowSize.Y * .75), (int) (windowSize.Y * .125)),
                    new Vector2((int) (windowSize.Y * .75), (int) (windowSize.Y * .125))
            });
        });

        System.out.println("switched to menu scene");
        System.out.println(windowSize);
        System.out.println();
        return menu;
    }

    private Scene gameScene(Stage stage) {
        Pane root = new Pane();
        Canvas canvas = new Canvas(windowSize.X += Offset.X * 2, windowSize.Y += Offset.Y);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Scene game = new Scene(root, windowSize.X, windowSize.Y);
        root.getChildren().add(canvas);

        Button[] squares = new Button[64];
        for (int i = 0; i < squares.length; i++) {
            squares[i] = new Button();
            root.getChildren().add(squares[i]);
            squares[i].setBackground(new Background(
                    new BackgroundFill(i % 2 == 0 ^ i / 8 % 2 == 1 ? Colors.DARK : Colors.LIGHT, null, null)));
            squares[i].setOnAction(e -> System.out.println("yo mama")); // TODO: make button inputs actually do stuff
        }

        game.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE)
                root.getChildren().add(addSettingsOverlay(game)); // TODO: settings overlay toggle
        });

        stage.widthProperty().addListener((observable, oldValue, newValue) -> {
            windowSize = new Vector2(newValue.intValue(), windowSize.Y);
            canvas.setWidth(windowSize.X);
            Draw.game(gc, windowSize);

            Resize.buttonX(squares, IntStream.range(0, squares.length).mapToObj(i -> new Vector2(
                    (windowSize.X - Math.min(windowSize.X - 400, windowSize.Y - 100)) / 2
                            + i % 8 * (Math.min(windowSize.X - 400, windowSize.Y - 100) / 8),
                    Math.min(windowSize.X - 400, windowSize.Y - 100) / 8))
                    .toArray(Vector2[]::new));

        });
        stage.heightProperty().addListener((observable, oldValue, newValue) -> {
            windowSize = new Vector2(windowSize.X, newValue.intValue());
            canvas.setHeight(windowSize.Y);
            Draw.game(gc, windowSize);

            Resize.buttonY(squares, IntStream.range(0, squares.length).mapToObj(i -> new Vector2(
                    (windowSize.Y - Math.min(windowSize.X - 400, windowSize.Y - 100)) / 2
                            + i / 8 * (Math.min(windowSize.X - 400, windowSize.Y - 100) / 8),
                    Math.min(windowSize.X - 400, windowSize.Y - 100) / 8))
                    .toArray(Vector2[]::new));
        });

        System.out.println("switched to game scene");
        System.out.println(windowSize);
        System.out.println();
        return game;
    }

    private Scene settingsScene(Stage stage) {
        Pane root = new Pane();
        Canvas canvas = new Canvas(windowSize.X += Offset.X * 2, windowSize.Y += Offset.Y);
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

        settings.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE)
                stage.setScene(menuScene(stage));
        });

        stage.widthProperty().addListener((observable, oldValue, newValue) -> {
            windowSize = new Vector2(newValue.intValue(), windowSize.Y);
            canvas.setWidth(windowSize.X);
            Draw.settings(gc, windowSize);

            Resize.buttonX(buttons, new Vector2[] {

            });
        });
        stage.heightProperty().addListener((observable, oldValue, newValue) -> {
            windowSize = new Vector2(windowSize.X, newValue.intValue());
            canvas.setHeight(windowSize.Y);
            Draw.settings(gc, windowSize);

            Resize.buttonY(buttons, new Vector2[] {

            });
        });

        System.out.println("switched to settings scene");
        System.out.println(windowSize);
        System.out.println();
        return settings;
    }

    private Pane addSettingsOverlay(Scene scene) {
        System.out.println("enabled settings pane");
        System.out.println(windowSize);
        System.out.println();
        return null;
    }

}
