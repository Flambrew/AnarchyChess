package src.piece.attributes;

/**
 * @author Andrew Matherne
 */
public enum Color {
    WHITE(1),
    BLACK(-1);
    
    public int sign;

    Color(int sign) {
        this.sign = sign;
    }
}
