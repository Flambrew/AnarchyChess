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

    /**
     * Cycles the enum by n.
     * 
     * @param n
     * @return Row
     */
    public Row move(int n) {
        Row row = this;
        for (int i = 0; i < (n % 8 + 8) % 8; i++)
            row = next(row);
        return row;
    }

    private Row next(Row row) {
        switch (row) {
            case _1:
                return _2;
            case _2:
                return _3;
            case _3:
                return _4;
            case _4:
                return _5;
            case _5:
                return _6;
            case _6:
                return _7;
            case _7:
                return _8;
            case _8:
                return _1;
            default:
                return null;
        }
    }
}
