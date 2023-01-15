package src.graphics;

import javafx.scene.canvas.GraphicsContext;

import src.graphics.graphicutils.Colors;
import src.graphics.graphicutils.Offset;
import src.utils.Vector2;

/**
 * @author Andrew Matherne
 */
public class Draw {

    /**
     * Draws the UI for the menu scene.
     * 
     * @param gc
     * @param windowSize
     */
    public static void menu(GraphicsContext gc, Vector2 windowSize) {
        gc.clearRect(0, 0, windowSize.X, windowSize.Y);

        gc.setFill(Colors.BACK);
        gc.fillRect(0, 0, windowSize.X, windowSize.Y);

        gc.setFill(Colors.MENU);
        gc.fillRoundRect(windowSize.X * .1 + Offset.X, windowSize.Y * .125 + Offset.Y, windowSize.X * .8,
                windowSize.Y * .5, 50, 50);
    }

    /**
     * Draws the UI for the game scene.
     * 
     * @param gc
     * @param windowSize
     */
    public static void game(GraphicsContext gc, Vector2 windowSize) {
        gc.clearRect(0, 0, windowSize.X, windowSize.Y);

        gc.setFill(Colors.BACK);
        gc.fillRect(0, 0, windowSize.X, windowSize.Y);
    }

    /**
     * Draws the UI for the settings scene.
     * 
     * @param gc
     * @param windowSize
     */
    public static void settings(GraphicsContext gc, Vector2 windowSize) {
        gc.clearRect(0, 0, windowSize.X, windowSize.Y);

        gc.setFill(Colors.BACK);
        gc.fillRect(0, 0, windowSize.X, windowSize.Y);

        gc.setFill(Colors.MENU);
        gc.fillRoundRect(windowSize.X * .1 + Offset.X, windowSize.Y * .125 + Offset.Y, windowSize.X * .8,
                windowSize.Y * .75, 50, 50);
    }
}
