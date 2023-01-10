package src.piece;

/**
 * @author Andrew Matherne
 */
public class Piece {

    private final PColor COLOR;
    private final PType TYPE;

    private PRow row;
    private PColumn column;

    private boolean hasBeenMoved;

    /**
     * Initializes a new <code>Piece</code>
     * 
     * @param color
     * @param type
     * @param row
     * @param column
     */
    public Piece(PColor color, PType type, PRow row, PColumn column) {
        this.COLOR = color;
        this.TYPE = type;
        this.row = row;
        this.column = column;
    }

    /**
     * Copies a <code>Piece</code>
     * 
     * @param other
     */
    public Piece(Piece other) {
        this.COLOR = other.COLOR;
        this.TYPE = other.TYPE;
        this.row = other.row;
        this.column = other.column;
    }

    /**
     * Returns the <code>PColor</code> attribute of the <code>Piece</code>
     * 
     * @return <code>PColor</code>
     */
    public PColor getColor() {
        return COLOR;
    }

    /**
     * Returns the <code>PType</code> attribute of the <code>Piece</code>
     * 
     * @return <code>PType</code>
     */
    public PType getType() {
        return TYPE;
    }

    /**
     * Returns the <code>PRow</code> attribute of the <code>Piece</code>
     * 
     * @return <code>PRow</code>
     */
    public PRow getRow() {
        return row;
    }

    /**
     * Returns the <code>PColumn</code> attribute of the <code>Piece</code>
     * 
     * @return <code>PColumn</code>
     */
    public PColumn getColumn() {
        return column;
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

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    public String toString() {
        return (COLOR.sign * TYPE.num > 0 ? " " : "") + Integer.toString(COLOR.sign * TYPE.num);
    }
}
