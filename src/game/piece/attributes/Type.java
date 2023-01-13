package src.game.piece.attributes;

/**
 * @author Andrew Matherne
 */
public enum Type {
    PAWN(1, 'p'),
    KNIGHT(2, 'n'),
    BISHOP(3, 'b'),
    ROOK(4, 'r'),
    QUEEN(5, 'q'),
    KING(6, 'k'),
    KNOOK(7, 'o');

    public final int num;
    public final char ch;

    Type(int num, char ch) {
        this.num = num;
        this.ch = ch;
    }
}
