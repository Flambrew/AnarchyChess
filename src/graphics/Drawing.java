package src.graphics;

import java.awt.*;
import javax.swing.*;

import src.graphics.scenes.MainScene;
import src.graphics.scenes.OverlayScene;

public class Drawing extends JPanel {

    private MainScene mainScene;
    private OverlayScene overlayScene;

    public Drawing() {
        mainScene = MainScene.MAIN_MENU;
        overlayScene = OverlayScene.NONE;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        switch (mainScene) {
            case MAIN_MENU:
                renderMenu(g);
                break;
            case GAME:
                break;
            default:
                break;

        }

        switch (overlayScene) {
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

        g.dispose();
        repaint();
    }

    private void renderMenu(Graphics g) {

    }

    public void setMainScene(MainScene screenState) {
        this.mainScene = screenState;
    }

    public void setOverlayScene(OverlayScene overlayState) {
        this.overlayScene = overlayState;
    }
}