package src.piece.attributes;

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
}