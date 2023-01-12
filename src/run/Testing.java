package src.run;

import src.graphics.Window;

public class Testing {

    private static Window graphicsHandler;
    public static void main(String[] args) {
        graphicsHandler = new Window("AnarchyChess");
        graphicsHandler.init();
    }
}