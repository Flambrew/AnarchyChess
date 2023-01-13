package src.main;

import src.game.constructs.Vector2;
import src.graphics.Window;

public class Testing {

    private static Window window;
    public static void main(String[] args) {
        window = new Window("AnarchyChess", new Vector2(1280, 720), true);
        window.init();
    }
}