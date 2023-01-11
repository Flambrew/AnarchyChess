package src.game;

import java.util.ArrayList;

import src.piece.Move;
import src.piece.Piece;
import src.utils.Vector2;

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
        Piece[][] pieces = generateBoardArray(board);
        for (Piece piece : board)
            switch (piece.TYPE) {
                case PAWN:
                    moves.addAll(getPawnMoves(piece, pieces));
                    break;
                case KNIGHT:
                    moves.addAll(getKnightMoves(piece, pieces));
                    break;
                case BISHOP:
                    moves.addAll(getBishopMoves(piece, pieces));
                    break;
                case ROOK:
                    moves.addAll(getRookMoves(piece, pieces));
                    break;
                case KNOOK:
                    moves.addAll(getKnookMoves(piece, pieces));
                    break;
                case QUEEN:
                    moves.addAll(getQueenMoves(piece, pieces));
                    break;
                case KING:
                    moves.addAll(getKingMoves(piece, pieces));
                    break;
                default:
                    break;
            }
        return moves;
    }

    private ArrayList<Move> getPawnMoves(Piece piece, Piece[][] pieces) {
        ArrayList<Move> moves = new ArrayList<Move>();
        // Capture
        // Move
        // Push
        // Promotion
        // Passant
        return moves;
    }

    private ArrayList<Move> getKnightMoves(Piece piece, Piece[][] pieces) {
        ArrayList<Move> moves = new ArrayList<Move>();

        Vector2[] lShapes = new Vector2[] {
                new Vector2(1, 2),
                new Vector2(1, -2),
                new Vector2(-1, 2),
                new Vector2(-1, -2),
                new Vector2(2, 1),
                new Vector2(2, -1),
                new Vector2(-2, 1),
                new Vector2(-2, -1)
        };

        for (Vector2 move : lShapes)
            try {
                if (pieces[piece.ROW.Y + move.Y][piece.COLUMN.X + move.X] == null)
                    // TODO figure out how to back-seek enums || IMPLEMENT A NEXT/INCREMENT FUNCTION
                    moves.add(new Move(piece.ROW, piece.COLUMN, null, null));
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }

        return moves;
    }

    private ArrayList<Move> getBishopMoves(Piece piece, Piece[][] pieces) {
        ArrayList<Move> moves = new ArrayList<Move>();
        // Diagonal x4

        // 'Il Vaticano'
        return moves;
    }

    private ArrayList<Move> getRookMoves(Piece piece, Piece[][] pieces) {
        ArrayList<Move> moves = new ArrayList<Move>();
        // Orthagonal x4
        return moves;
    }

    private ArrayList<Move> getKnookMoves(Piece piece, Piece[][] pieces) {
        ArrayList<Move> moves = new ArrayList<Move>();
        moves.addAll(getKnightMoves(piece, pieces));
        moves.addAll(getRookMoves(piece, pieces));
        return moves;
    }

    private ArrayList<Move> getQueenMoves(Piece piece, Piece[][] pieces) {
        ArrayList<Move> moves = new ArrayList<Move>();
        moves.addAll(getBishopMoves(piece, pieces));
        moves.addAll(getRookMoves(piece, pieces));

        // 'Beta Decay'
        return moves;
    }

    private ArrayList<Move> getKingMoves(Piece piece, Piece[][] pieces) {
        ArrayList<Move> moves = new ArrayList<Move>();
        // Move
        // Castle

        // 'Pawn Push'
        // No C2
        return moves;
    }

    private Piece[][] generateBoardArray(ArrayList<Piece> board) {
        Piece[][] pieces = new Piece[8][8];
        for (Piece piece : board)
            pieces[7 - piece.ROW.Y][piece.COLUMN.X] = piece;
        return pieces;
    }
}
