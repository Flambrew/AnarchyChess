package src.piece;

/**
 * @author Andrew Matherne
 */
public enum PColor {
    NONE(0),
    WHITE(1),
    BLACK(-1);
    
    public int sign;

    PColor(int sign) {
        this.sign = sign;
    }
}
