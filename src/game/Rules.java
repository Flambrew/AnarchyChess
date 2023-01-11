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
            switch (piece.TYPE) {
                case PAWN:
                    moves.addAll(getPawnMoves(piece));
                    break;
                case KNIGHT:
                    moves.addAll(getKnightMoves(piece));
                    break;
                case BISHOP:
                    moves.addAll(getBishopMoves(piece));
                    break;
                case ROOK:
                    moves.addAll(getRookMoves(piece));
                    break;
                case QUEEN:
                    moves.addAll(getQueenMoves(piece));
                    break;
                case KING:
                    moves.addAll(getKingMoves(piece));
                    break;
                case KNOOK:
                    moves.addAll(getKnookMoves(piece));
                    break;
                default:
                    break;
            }
        return moves;
    }

    private ArrayList<Move> getPawnMoves(Piece piece) {
        ArrayList<Move> moves = new ArrayList<Move>();
        // Capture
        // Move
        // Push
        // Promotion
        // Passant
        return moves;
    }

    private ArrayList<Move> getKnightMoves(Piece piece) {
        ArrayList<Move> moves = new ArrayList<Move>();
        // L-shape
        return moves;
    }

    private ArrayList<Move> getBishopMoves(Piece piece) {
        ArrayList<Move> moves = new ArrayList<Move>();
        // Diagonal x4

        // 'Il Vaticano'
        return moves;
    }

    private ArrayList<Move> getRookMoves(Piece piece) {
        ArrayList<Move> moves = new ArrayList<Move>();
        // Orthagonal x4
        return moves;
    }

    private ArrayList<Move> getKnookMoves(Piece piece) {
        ArrayList<Move> moves = new ArrayList<Move>();
        moves.addAll(getKnightMoves(piece));
        moves.addAll(getRookMoves(piece));
        return moves;
    }

    private ArrayList<Move> getQueenMoves(Piece piece) {
        ArrayList<Move> moves = new ArrayList<Move>();
        moves.addAll(getBishopMoves(piece));
        moves.addAll(getRookMoves(piece));

        // 'Beta Decay'
        return moves;
    }

    private ArrayList<Move> getKingMoves(Piece piece) {
        ArrayList<Move> moves = new ArrayList<Move>();
        // Move
        // Castle

        // 'Pawn Push'
        // No C2
        return moves;
    }
}
