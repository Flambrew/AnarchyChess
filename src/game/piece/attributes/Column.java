package src.game.piece.attributes;

/**
 * @author Andrew Matherne
 */
public enum Column {
    A(0),
    B(1),
    C(2),
    D(3),
    E(4),
    F(5),
    G(6),
    H(7);

    public final int X;

    Column(int n) {
        this.X = n;
    }

    /**
     * Cycles the enum by n.
     * 
     * @param n
     * @return Column
     */
    public Column move(int n) {
        Column column = this;
        for (int i = 0; i < (n % 8 + 8) % 8; i++)
            column = next(column);
        return column;
    }

    private Column next(Column column) {
        switch (column) {
            case A:
                return B;
            case B:
                return C;
            case C:
                return D;
            case D:
                return E;
            case E:
                return F;
            case F:
                return G;
            case G:
                return H;
            case H:
                return A;
            default:
                return null;
        }
    }
}