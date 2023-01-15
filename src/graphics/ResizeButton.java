package src.graphics;

import javafx.scene.control.Button;
import src.graphics.graphicutils.Offset;
import src.utils.Vector2;

/**
 * @author Andrew Matherne
 */
public class ResizeButton {

    /**
     * Resizes every button on its x-axis provided based on a new transform.
     * 
     * @param buttons
     * @param transforms
     */
    public static void x(Button[] buttons, Vector2[] transforms) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setLayoutX(transforms[i].X + Offset.X);
            buttons[i].setPrefWidth(transforms[i].Y);
        }
    }

    /**
     * Resizes every button on its y-axis provided based on a new transform.
     * 
     * @param buttons
     * @param transforms
     */
    public static void y(Button[] buttons, Vector2[] transforms) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setLayoutY(transforms[i].X + Offset.Y);
            buttons[i].setPrefHeight(transforms[i].Y);
        }
    }
}
