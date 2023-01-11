package src.piece.attributes;

/**
 * @author Andrew Matherne
 */
public enum Color {
    WHITE(1),
    BLACK(-1);
    
    public final int sign;

    Color(int sign) {
        this.sign = sign;
    }
}
