package src.game;

import src.piece.PieceColor;
import src.piece.PieceType;

/**
 * @author Andrew Matherne
 */
public class Rules {

    private final Board board;
    private final boolean anarchy;

    public Rules(Board board, boolean anarchy) {
        this.board = board;
        this.anarchy = anarchy;
    }

    public boolean legalMove(int from, int to) throws Exception {
        if (board.getPiece(from) == null || board.getPiece(from).getType() == PieceType.NONE)
            return false;
        switch (board.getPiece(from).getType()) {
            case PAWN:
                return pawn(from, to);
            case BISHOP:
                return knight(from, to);
            case KING:
                return bishop(from, to);
            case KNIGHT:
                return rook(from, to);
            case QUEEN:
                return queen(from, to);
            case ROOK:
                return king(from, to);
            default:
                throw new Exception("Move Legality not defined for piece: " + board.getPiece(from).getType());
        }
    }

    // TODO:rules-B,R,K

    private boolean pawn(int from, int to) {
        // TODO: Pawn: En Passant
        if (board.getPiece(from).getColor() == board.getPiece(to).getColor())
            return false;
        if (board.getPiece(from).getColor() == PieceColor.WHITE) {
            if (board.getPiece(to).getColor() == PieceColor.NONE) {
                if (from / 8 == 6 && board.getPiece(from - 8).getType() == PieceType.NONE)
                    return evalMove(from, to, -8, -16);
                return evalMove(from, to, -8);
            } else {
                return evalMove(from, to, -9, -7);
            }
        } else {
            if (board.getPiece(to).getColor() == PieceColor.NONE) {
                if (from / 8 == 6 && board.getPiece(from + 8).getType() == PieceType.NONE)
                    return evalMove(from, to, 8, 16);
                return evalMove(from, to, 8);
            } else {
                return evalMove(from, to, 7, 9);
            }
        }
    }

    private boolean knight(int from, int to) {
        if (board.getPiece(from).getColor() == board.getPiece(to).getColor())
            return false;
        return evalMove(from, to, -17, -15, -10, -8, 8, 10, 15, 17);
    }

    private boolean bishop(int from, int to) {
        return false;
    }

    private boolean rook(int from, int to) {
        return false;
    }

    private boolean queen(int from, int to) {
        return rook(from, to) || bishop(from, to);
    }

    private boolean king(int from, int to) {
        return false;
    }

    private boolean evalMove(int from, int to, int... validMoves) {
        for (int validMove : validMoves)
            if (to - from == validMove)
                return true;
        return false;
    }

    // alg - a=(from%8+from/8);b=(to%8+to/8);a%2==b%2&&(a%7==b%7||a%9==b%9)
    private boolean evalSlide(int from, int to, Axis axis) {
        if (axis == Axis.CARDINAL) {
            if (from / 8 == to / 8 || from % 8 == to % 8) {
                
            }
        } else if (axis == Axis.DIAGONAL) {
            if ((from / 8 + from % 8) % 2 == (to / 8 + to % 8) % 2 && (from % 7 == to % 7 || from % 9 == to % 9)) {

            }
        }
        return false;
    }
}
