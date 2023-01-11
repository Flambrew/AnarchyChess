package src.piece.attributes;

/**
 * @author Andrew Matherne
 */
public enum Row {
    _1(0),
    _2(1),
    _3(2),
    _4(3),
    _5(4),
    _6(5),
    _7(6),
    _8(7);
    
    public final int Y;

    Row(int n) {
        this.Y = n;
    }
}
