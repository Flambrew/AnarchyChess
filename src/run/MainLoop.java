package src.run;

import java.util.ArrayList;

import src.game.Board;
import src.game.Rules;
import src.piece.Move;
import src.piece.Piece;
import src.piece.attributes.Color;

/**
 * Anarchy Chess
 * Chess, with extra rules implemented from the r/AnarchyChess subreddit
 * 
 * @author Andrew Matherne
 * @since 01.04.2023
 */

public class MainLoop {

    public static Board board = new Board();
    public static Color color;

    public static void main(String[] args) {
        while (true) { // turnloop

            System.out.println(board);

            while (true) { // white turn
                color = Color.WHITE;

                ArrayList<Move> moves = Rules.getMoves(board, color);
                // print(moves);

                Move m = moves.get((int) (Math.random() * moves.size()));
                for (Piece p : board.board())
                    if (p.ROW == m.ROW && p.COLUMN == m.COLUMN) {
                        p.move(m);
                        break;
                    }

                break;
            }

            System.out.println(board);

            while (true) { // black turn
                color = Color.BLACK;

                ArrayList<Move> moves = Rules.getMoves(board, color);
                // print(moves);

                Move m = moves.get((int) (Math.random() * moves.size()));
                for (Piece p : board.board())
                    if (p.ROW == m.ROW && p.COLUMN == m.COLUMN) {
                        p.move(m);
                        break;
                    }

                break;
            }
        }
    }

    public static void print(ArrayList<Move> moves) {
        for (Move move : moves)
            System.out.println(move);
    }
}