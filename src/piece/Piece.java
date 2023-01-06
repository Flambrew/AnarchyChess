package src.piece;

/**
 * @author Andrew Matherne
 */
public class Piece {

    private final PieceColor COLOR;
    private final PieceType TYPE;

    private boolean hasBeenMoved;

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
     * Copy constructor for <code>Piece</code>
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
    
    /**
     * Returns whether the <code>Piece</code> has been moved or not
     * 
     * @return boolean
     */
    public boolean hasBeenMoved() {
        return hasBeenMoved;
    }
    
    /**
     * Sets <code>Piece.hasBeenMoved</code> to true
     */
    public void wasMoved() {
        hasBeenMoved = true;
    }

    public String toString() {
        return Integer.toString(COLOR.sign * TYPE.num);
    }
}
