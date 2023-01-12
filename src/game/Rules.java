package src.game;

import java.util.ArrayList;

import src.piece.Move;
import src.piece.Piece;
import src.piece.attributes.Color;
import src.piece.attributes.Row;
import src.utils.Vector2;

/**
 * @author Andrew Matherne
 */
public class Rules {

    private static boolean anarchy = false;
    private static final Vector2[] WHITE_PAWN_CAPTURES = new Vector2[] {
            new Vector2(1, 1),
            new Vector2(-1, 1)
    };
    private static final Vector2[] WHITE_PAWN_MOVE = new Vector2[] {
            new Vector2(0, 1)
    };
    private static final Vector2[] WHITE_PAWN_PUSH = new Vector2[] {
            new Vector2(0, 2)
    };
    private static final Vector2[] BLACK_PAWN_CAPTURES = new Vector2[] {
            new Vector2(1, -1),
            new Vector2(-1, -1)
    };
    private static final Vector2[] BLACK_PAWN_MOVE = new Vector2[] {
            new Vector2(0, -1)
    };
    private static final Vector2[] BLACK_PAWN_PUSH = new Vector2[] {
            new Vector2(0, -2)
    };
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
     * Sets state of Rules.anarchy.
     * 
     * @param state
     */
    public static void anarchy(boolean state) {
        anarchy = state;
    }

    /**
     * Returns the current state of Rules.anarchy.
     * 
     * @return boolean
     */
    public static boolean anarchy() {
        return anarchy;
    }

    /**
     * Returns an ArrayList of Moves representing every legal move on the board.
     * 
     * @param board
     * @return ArrayList of Move
     */
    public static ArrayList<Move> getLegalMoves(Board board) {
        ArrayList<Move> m = new ArrayList<Move>();
        Piece[][] b = generateBoardArray(board.board());
        for (Piece p : board.board())
            switch (p.TYPE) {
                case PAWN:
                    if (p.COLOR == Color.WHITE) {
                        directMove(m, b, p, WHITE_PAWN_CAPTURES, false, true);
                        directMove(m, b, p, WHITE_PAWN_MOVE, true, false);
                        if (p.ROW == Row._2)
                            slideMove(m, b, p, WHITE_PAWN_PUSH, true, false, 2);
                    } else {
                        directMove(m, b, p, BLACK_PAWN_CAPTURES, false, true);
                        directMove(m, b, p, BLACK_PAWN_MOVE, true, false);
                        if (p.ROW == Row._7)
                            slideMove(m, b, p, BLACK_PAWN_PUSH, true, false, 2);
                    }
                    // TODO: Pawn Promotion, Passant
                    break;
                case KNIGHT:
                    directMove(m, b, p, L_SHAPES, true, true);
                    break;
                case BISHOP:
                    slideMove(m, b, p, DIAGONALS, true, true);
                    // TODO: Bishop 'Il Vaticano'
                    break;
                case ROOK:
                    slideMove(m, b, p, ORTHAGONALS, true, true);
                    // TODO: Rook Castling
                    break;
                case KNOOK:
                    directMove(m, b, p, L_SHAPES, true, true);
                    slideMove(m, b, p, ORTHAGONALS, true, true);
                    break;
                case QUEEN:
                    slideMove(m, b, p, DIAGONALS, true, true);
                    slideMove(m, b, p, ORTHAGONALS, true, true);
                    // TODO: Queen 'Beta Decay'
                    break;
                case KING:
                    // TODO: King Move, Castling, 'Pawn Push', No C2
                    break;
                default:
                    break;
            }
        return m;
    }

    private static void directMove(ArrayList<Move> moves, Piece[][] pieces, Piece piece, Vector2[] locationList,
            boolean habitable, boolean capturable) {
        for (Vector2 move : locationList)
            try {
                Piece activePiece = pieces[piece.ROW.Y + move.Y][piece.COLUMN.X + move.X];
                if (habitable && activePiece == null || capturable && activePiece.COLOR != piece.COLOR)
                    moves.add(new Move(piece.ROW, piece.COLUMN, piece.ROW.move(move.Y), piece.COLUMN.move(move.X)));
            } catch (Exception e) {
            }
    }

    private static void slideMove(ArrayList<Move> moves, Piece[][] pieces, Piece piece, Vector2[] directionList,
            boolean habitable, boolean capturable) {
        slideMove(moves, pieces, piece, directionList, habitable, capturable, pieces.length);
    }

    // TODO: FIX TRAVEL ACROSS CAPTURABLE
    private static void slideMove(ArrayList<Move> moves, Piece[][] pieces, Piece piece, Vector2[] directionList,
            boolean habitable, boolean capturable, int distance) {
        for (Vector2 move : directionList)
            for (int i = 1; i < distance; i++)
                try {
                    Piece activePiece = pieces[piece.ROW.Y + (move.Y * i)][piece.COLUMN.X + (move.X * i)];
                    if (habitable && activePiece == null || capturable && activePiece.COLOR != piece.COLOR)
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
