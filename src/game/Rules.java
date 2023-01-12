package src.game;

import java.util.ArrayList;

import src.piece.Move;
import src.piece.Piece;
import src.utils.Vector2;

/**
 * @author Andrew Matherne
 */
public class Rules {

    private static boolean anarchy = false;
    private static final Vector2[] L_SHAPES = new Vector2[] {
            new Vector2(1, 2),
            new Vector2(1, -2),
            new Vector2(-1, 2),
            new Vector2(-1, -2),
            new Vector2(2, 1),
            new Vector2(2, -1),
            new Vector2(-2, 1),
            new Vector2(-2, -1)
    };
    private static final Vector2[] DIAGONALS = new Vector2[] {
            new Vector2(1, 1),
            new Vector2(1, -1),
            new Vector2(-1, 1),
            new Vector2(-1, -1)
    };
    private static final Vector2[] ORTHAGONALS = new Vector2[] {
            new Vector2(0, 1),
            new Vector2(0, -1),
            new Vector2(1, 0),
            new Vector2(-1, 0)
    };

    /**
     * Used to set Rules.anarchy.
     * Does not change if no value is supplied.
     * Returns the current state.
     * 
     * @param state
     * @return boolean
     */
    public static boolean anarchy(boolean... state) {
        if (state == null || state.length != 1)
            return anarchy;
        return anarchy = state[0];
    }

    /**
     * Returns an ArrayList of Moves representing every legal move on the board.
     * 
     * @param board
     * @return ArrayList of Move
     */
    public static ArrayList<Move> getLegalMoves(ArrayList<Piece> board) {
        ArrayList<Move> moves = new ArrayList<Move>();
        Piece[][] pieces = generateBoardArray(board);
        for (Piece piece : board)
            switch (piece.TYPE) {
                case PAWN:
                    // TODO: Pawn Capture
                    // TODO: Pawn Move
                    // TODO: Pawn Push
                    // TODO: Pawn Promotion
                    // TODO: Pawn Passant
                    break;
                case KNIGHT:
                    directMove(moves, pieces, piece, L_SHAPES);
                    break;
                case BISHOP:
                    slideMove(moves, pieces, piece, DIAGONALS);
                    // TODO: Bishop 'Il Vaticano'
                    break;
                case ROOK:
                    slideMove(moves, pieces, piece, ORTHAGONALS);
                    // TODO: Rook Castling
                    break;
                case KNOOK:
                    directMove(moves, pieces, piece, L_SHAPES);
                    slideMove(moves, pieces, piece, ORTHAGONALS);
                    break;
                case QUEEN:
                    slideMove(moves, pieces, piece, DIAGONALS);
                    slideMove(moves, pieces, piece, ORTHAGONALS);
                    // TODO: Queen 'Beta Decay'
                    break;
                case KING:
                    // TODO: King Move
                    // TODO: King Castling
                    // TODO: King 'Pawn Push'
                    // TODO: King No C2
                    break;
                default:
                    break;
            }
        return moves;
    }

    private static void directMove(ArrayList<Move> moves, Piece[][] pieces, Piece piece, Vector2[] list) {
        for (Vector2 move : list)
            try {
                if (pieces[piece.ROW.Y + move.Y][piece.COLUMN.X + move.X] == null)
                    moves.add(new Move(piece.ROW, piece.COLUMN, piece.ROW.move(move.Y), piece.COLUMN.move(move.X)));
            } catch (Exception e) {
            }
    }

    private static void slideMove(ArrayList<Move> moves, Piece[][] pieces, Piece piece, Vector2[] list) {
        slideMove(moves, pieces, piece, list, pieces.length);
    }

    private static void slideMove(ArrayList<Move> moves, Piece[][] pieces, Piece piece, Vector2[] list, int distance) {
        for (Vector2 move : list)
            for (int i = 1; i < distance; i++)
                try {
                    if (pieces[piece.ROW.Y + (move.Y * i)][piece.COLUMN.X + (move.X * i)] == null)
                        moves.add(new Move(piece.ROW, piece.COLUMN, piece.ROW.move(move.Y * i),
                                piece.COLUMN.move(move.X * i)));
                    else
                        break;
                } catch (Exception e) {
                    break;
                }
    }

    private static Piece[][] generateBoardArray(ArrayList<Piece> board) {
        Piece[][] pieces = new Piece[8][8];
        for (Piece piece : board)
            pieces[7 - piece.ROW.Y][piece.COLUMN.X] = piece;
        return pieces;
    }
}
