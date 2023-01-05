package src.piece;

/**
 * @author Andrew Matherne
 */
public class Piece {

    private final PieceColor COLOR;
    private final PieceType TYPE;

    /**
     * Initializes a new <code>Piece</code> given a <code>PieceColor</code> and
     * <code>PieceType</code>
     * 
     * @param color
     * @param type
     */
    public Piece(PieceColor color, PieceType type) {
        this.COLOR = color;
        this.TYPE = type;
    }

    /**
     * Initializes a new <code>Piece</code> as a clone of a <code>Piece</code>
     * 
     * @param other
     */
    public Piece(Piece other) {
        this.COLOR = other.COLOR;
        this.TYPE = other.TYPE;
    }

    /**
     * Returns the <code>PieceColor</code> attribute of the <code>Piece</code>
     * 
     * @return <code>PieceColor</code>
     */
    public PieceColor getColor() {
        return COLOR;
    }

    /**
     * Returns the <code>PieceType</code> attribute of the <code>Piece</code>
     * 
     * @return <code>PieceType</code>
     */
    public PieceType getType() {
        return TYPE;
    }

    public String toString() {
        return Integer.toString(COLOR.sign * TYPE.num);
    }
}
