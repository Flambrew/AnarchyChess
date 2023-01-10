package src.piece.attributes;

/**
 * @author Andrew Matherne
 */
public enum Type {
    NONE(0),
    PAWN(1),
    KNIGHT(2),
    BISHOP(3),
    ROOK(4),
    QUEEN(5),
    KING(6),
    KNOOK(7);

    public int num;

    Type(int num) {
        this.num = num;
    }
}
