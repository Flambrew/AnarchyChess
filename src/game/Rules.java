package src.game;

import java.util.ArrayList;

import src.piece.Move;
import src.piece.Piece;

/**
 * @author Andrew Matherne
 */
public class Rules {

    private boolean anarchy = false;

    public boolean anarchy(boolean... state) {
        if (state == null || state.length != 1)
            return anarchy;
        return anarchy = state[0];
    }

    public ArrayList<Move> getLegalMoves(ArrayList<Piece> board) {
        ArrayList<Move> moves = new ArrayList<Move>();
        for (Piece piece : board)
            moves.addAll(getLegalMoves(piece));
        return moves;
    }

    private ArrayList<Move> getLegalMoves(Piece piece) {
        int row = piece.row().num;
        int column = piece.column().num;

        switch (piece.type()) {
            case BISHOP:
                break;
            case KING:
                break;
            case KNIGHT:
                break;
            case KNOOK:
                break;
            case PAWN:
                break;
            case QUEEN:
                break;
            case ROOK:
                break;
            default:
                break;
        }
        return null;
    }
}
