package src.graphics;

import javax.swing.JFrame;

import java.awt.Color;
//import java.awt.event.ComponentEvent;
//import java.awt.event.ComponentAdapter;

import src.game.constructs.Vector2;

public class Window {

    private JFrame frame;
    //private Drawing drawing;

    private Vector2 windowSize;

    private boolean exitsOnClose;

    public Window() {
        this.frame = new JFrame("Window");
        //this.drawing = new Drawing();
        this.windowSize = new Vector2(1280, 720);
        this.exitsOnClose = true;
    }

    public Window(String name, Vector2 windowSize, boolean exitsOnClose) {
        this.frame = new JFrame(name);
        //this.drawing = new Drawing();
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
        frame.setBackground(Color.RED);
        frame.setVisible(true);
        frame.toFront();
        //frame.add(drawing);

        /* frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {

            }
        });*/
    }
}
