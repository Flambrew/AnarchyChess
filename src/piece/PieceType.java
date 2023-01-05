package src.piece;

/**
 * @author Andrew Matherne
 */
public enum PieceType {
    NONE(0),
    PAWN(1),
    KNIGHT(2),
    BISHOP(3),
    ROOK(4),
    QUEEN(5),
    KING(6);

    int num;

    PieceType(int num) {
        this.num = num;
    }
}
