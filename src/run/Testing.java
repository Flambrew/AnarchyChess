package src.run;

import src.game.Board;
import src.game.Rules;
import src.piece.Move;

public class Testing {
    public static void main(String[] args) {
        Board b = new Board();
        for (Move move : Rules.getLegalMoves(b.board()))
            System.out.print(move);
    }
}