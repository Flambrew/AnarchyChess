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

    // Direct Moves
    private static final Vector2[] WHITE_PAWN_CAPTURES = new Vector2[] {
            new Vector2(1, 1),
            new Vector2(-1, 1)
    };
    private static final Vector2[] WHITE_PAWN_MOVE = new Vector2[] {
            new Vector2(0, 1)
    };
    private static final Vector2[] BLACK_PAWN_CAPTURES = new Vector2[] {
            new Vector2(1, -1),
            new Vector2(-1, -1)
    };
    private static final Vector2[] BLACK_PAWN_MOVE = new Vector2[] {
            new Vector2(0, -1)
    };

    // Slide Moves
    private static final Vector2[] WHITE_PAWN_PUSH = new Vector2[] {
            new Vector2(0, 1)
    };
    private static final Vector2[] BLACK_PAWN_PUSH = new Vector2[] {
            new Vector2(0, -1)
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
    public static ArrayList<Move> getLegalMoves(Board board, Color color) {
        ArrayList<Move> m = new ArrayList<Move>();
        Piece[][] b = generateBoardArray(board.board());
        for (Piece p : board.board())
            if (p.COLOR == color)
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

    private static void directMove(ArrayList<Move> moves, Piece[][] pieces, Piece p, Vector2[] locationList,
            boolean habitable, boolean capturable) {
        for (Vector2 move : locationList)
            try {
                Piece activePiece = pieces[p.ROW.Y + move.Y][p.COLUMN.X + move.X];
                if (habitable && activePiece == null || capturable && activePiece.COLOR != p.COLOR)
                    moves.add(new Move(p.ROW, p.COLUMN, p.ROW.move(move.Y), p.COLUMN.move(move.X)));
            } catch (Exception e) {
            }
    }

    private static void slideMove(ArrayList<Move> moves, Piece[][] pieces, Piece p, Vector2[] directionList,
            boolean habitable, boolean capturable) {
        slideMove(moves, pieces, p, directionList, habitable, capturable, pieces.length);
    }

    private static void slideMove(ArrayList<Move> moves, Piece[][] pieces, Piece p, Vector2[] directionList,
            boolean habitable, boolean capturable, int distance) {
        /*for (Vector2 move : directionList) //TODO: slidemove - this shit brokey
            for (int i = 1; i < distance; i++)
                try {
                    Piece activePiece = pieces[p.ROW.Y + (move.Y * i)][p.COLUMN.X + (move.X * i)];
                    if (habitable && activePiece == null)
                        moves.add(new Move(p.ROW, p.COLUMN, p.ROW.move(move.Y * i), p.COLUMN.move(move.X * i)));
                    else if (activePiece.COLOR != p.COLOR) {
                        if (capturable)
                            moves.add(new Move(p.ROW, p.COLUMN, p.ROW.move(move.Y * i), p.COLUMN.move(move.X * i)));
                        break;
                    } else
                        break;
                } catch (Exception e) {
                    break;
                }*/
    }

    private static Piece[][] generateBoardArray(ArrayList<Piece> board) {
        Piece[][] pieces = new Piece[8][8];
        for (Piece piece : board)
            pieces[piece.ROW.Y][piece.COLUMN.X] = piece;
        return pieces;
    }
}
