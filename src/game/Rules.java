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

    private static ArrayList<Move> getPawnMoves(Piece piece, Piece[][] pieces) {
        ArrayList<Move> moves = new ArrayList<Move>();
        // TODO: Pawn Capture
        // TODO: Pawn Move
        // TODO: Pawn Push
        // TODO: Pawn Promotion
        // TODO: Pawn Passant
        return moves;
    }

    private static ArrayList<Move> getKnightMoves(Piece piece, Piece[][] pieces) {
        ArrayList<Move> moves = new ArrayList<Move>();

        directMove( moves, pieces, piece);
        
        // L Shapes
        for (Vector2 move : L_SHAPES)
            try {
                if (pieces[piece.ROW.Y + move.Y][piece.COLUMN.X + move.X] == null)
                    moves.add(new Move(piece.ROW, piece.COLUMN, piece.ROW.move(move.Y), piece.COLUMN.move(move.X)));
            } catch (Exception e) {
            }

        return moves;
    }

    private static ArrayList<Move> getBishopMoves(Piece piece, Piece[][] pieces) {
        ArrayList<Move> moves = new ArrayList<Move>();

        // Diagonals
        for (Vector2 move : DIAGONALS)
            for (int i = 1;; i++)
                try {
                    if (pieces[piece.ROW.Y + (move.Y * i)][piece.COLUMN.X + (move.X * i)] == null)
                        moves.add(new Move(piece.ROW, piece.COLUMN, piece.ROW.move(move.Y * i),
                                piece.COLUMN.move(move.X * i)));
                    else
                        break;
                } catch (Exception e) {
                    break;
                }

        // TODO: Bishop 'Il Vaticano'

        return moves;
    }

    private static ArrayList<Move> getRookMoves(Piece piece, Piece[][] pieces) {
        ArrayList<Move> moves = new ArrayList<Move>();

        // Orthagonals
        for (Vector2 move : ORTHAGONALS)
            for (int i = 1;; i++)
                try {
                    if (pieces[piece.ROW.Y + (move.Y * i)][piece.COLUMN.X + (move.X * i)] == null)
                        moves.add(new Move(piece.ROW, piece.COLUMN, piece.ROW.move(move.Y * i),
                                piece.COLUMN.move(move.X * i)));
                    else
                        break;
                } catch (Exception e) {
                    break;
                }

        // TODO: Rook Castling

        return moves;
    }

    private static ArrayList<Move> getKnookMoves(Piece piece, Piece[][] pieces) {
        ArrayList<Move> moves = new ArrayList<Move>();
        moves.addAll(getKnightMoves(piece, pieces));
        moves.addAll(getRookMoves(piece, pieces));
        return moves;
    }

    private static ArrayList<Move> getQueenMoves(Piece piece, Piece[][] pieces) {
        ArrayList<Move> moves = new ArrayList<Move>();
        moves.addAll(getBishopMoves(piece, pieces));
        moves.addAll(getRookMoves(piece, pieces));

        // TODO: Queen 'Beta Decay'
        return moves;
    }

    private static ArrayList<Move> getKingMoves(Piece piece, Piece[][] pieces) {
        ArrayList<Move> moves = new ArrayList<Move>();
        // TODO: King Move
        // TODO: King Castle

        // TODO: King 'Pawn Push'
        // TODO: King No C2
        return moves;
    }

    private static void directMove(ArrayList<Move> moves, Piece[][] pieces, Piece piece) {
        
    }

    private static Piece[][] generateBoardArray(ArrayList<Piece> board) {
        Piece[][] pieces = new Piece[8][8];
        for (Piece piece : board)
            pieces[7 - piece.ROW.Y][piece.COLUMN.X] = piece;
        return pieces;
    }
}
