package src.graphics;

import javax.swing.JFrame;

import src.game.constructs.Vector2;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Window {

    private JFrame frame;
    private Vector2 windowSize;

    private boolean exitsOnClose;

    public Window() {
        this.frame = new JFrame("Window");
        this.windowSize = new Vector2(1280, 720);
        this.exitsOnClose = true;
    }

    public Window(String name) {
        this.frame = new JFrame(name);
        this.windowSize = new Vector2(1280, 720);
        this.exitsOnClose = true;
    }

    public Window(String name, Vector2 windowSize) {
        this.frame = new JFrame(name);
        this.windowSize = new Vector2(windowSize.X, windowSize.Y);
        this.exitsOnClose = true;
    }

    public Window(String name, boolean exitsOnClose) {
        this.frame = new JFrame(name);
        this.windowSize = new Vector2(1280, 720);
        this.exitsOnClose = exitsOnClose;
    }

    public Window(String name, Vector2 windowSize, boolean exitsOnClose) {
        this.frame = new JFrame(name);
        this.windowSize = new Vector2(windowSize.X, windowSize.Y);
        this.exitsOnClose = exitsOnClose;
    }

    public boolean exitsOnClose() {
        return exitsOnClose;
    }

    public void setExitsOnClose(boolean exitsOnClose) {
        this.exitsOnClose = exitsOnClose;
    }

    public void init() {
        frame.setDefaultCloseOperation(exitsOnClose ? 3 : 1);
        frame.setSize(windowSize.X, windowSize.Y);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.addComponentListener(new ComponentListener() {
            public void componentResized(ComponentEvent e) {
                // Redraw pieces/board given new size
            }

            public void componentMoved(ComponentEvent e) {
            }

            public void componentShown(ComponentEvent e) {
            }

            public void componentHidden(ComponentEvent e) {
            }
        });
    }
}
