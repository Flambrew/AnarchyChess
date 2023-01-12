package src.graphics;

import java.awt.*;
import javax.swing.*;

import src.graphics.states.OverlayState;
import src.graphics.states.ScreenState;

public class Drawing extends JPanel {

    private ScreenState screenState;
    private OverlayState overlayState;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        switch (screenState) {
            case MAIN_MENU:
                break;
            case GAME:
                break;
            default:
                break;

        }

        switch (overlayState) {
            case NONE:
                break;
            case SETTINGS:
                break;
            case GAME_OVER:
                break;
            case COMMAND_LINE_INTERFACE:
                break;
            default:
                break;
        }
    }

    public void setScreenState(ScreenState screenState) {
        this.screenState = screenState;
    }

    public void setOverlayState(OverlayState overlayState) {
        this.overlayState = overlayState;
    }
}