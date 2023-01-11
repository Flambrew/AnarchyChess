package src.piece;

import src.piece.attributes.Color;
import src.piece.attributes.Column;
import src.piece.attributes.Row;
import src.piece.attributes.Type;

/**
 * @author Andrew Matherne
 */
public class Piece {

    public final Color COLOR;
    public final Type TYPE;

    public Row ROW;
    public Column COLUMN;

    private boolean hasBeenMoved;

    /**
     * Initializes a new <code>Piece</code>
     * 
     * @param color
     * @param type
     * @param row
     * @param column
     */
    public Piece(Color color, Type type, Row row, Column column) {
        this.COLOR = color;
        this.TYPE = type;
        this.ROW = row;
        this.COLUMN = column;
    }

    /**
     * Copies a <code>Piece</code>
     * 
     * @param other
     */
    public Piece(Piece other) {
        this.COLOR = other.COLOR;
        this.TYPE = other.TYPE;
        this.ROW = other.ROW;
        this.COLUMN = other.COLUMN;
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
