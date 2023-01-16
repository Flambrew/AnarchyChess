package src.main;

import java.util.ArrayList;

import javafx.application.Application;
import src.game.Board;
import src.game.Rules;
import src.game.piece.Move;
import src.game.piece.attributes.Color;
import src.graphics.WindowInitializer;

/**
 * Anarchy Chess
 * Chess, with extra rules implemented from the r/AnarchyChess subreddit
 * 
 * @author Andrew Matherne
 * @since 01.04.2023
 */

public class MainLoop {

    private static Board board;
    private static Color color;
    private static boolean anarchy;
    
    public static boolean isAnarchy() {
        return anarchy;
    }

    public static void setAnarchy(boolean anarchy) {
        MainLoop.anarchy = anarchy;
    }

    public static void main(String[] args) {
        board = new Board();

        Application.launch(WindowInitializer.class, args);
    }

    private void runGame() {
        while (true) { // turnloop

            System.out.println(board);

            while (true) { // white turn
                color = Color.WHITE;
                ArrayList<Move> moves = Rules.getLegalMoves(board, color);
                // print(moves);

                Move m = moves.get((int) (Math.random() * moves.size()));
                board.move(m);

                break;
            }

            System.out.println(board);

            while (true) { // black turn
                color = Color.BLACK;
                ArrayList<Move> moves = Rules.getLegalMoves(board, color);
                // print(moves);

                Move m = moves.get((int) (Math.random() * moves.size()));
                board.move(m);

                break;
            }
        }
    }
}