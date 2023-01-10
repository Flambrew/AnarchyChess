package src.piece;

import src.piece.attributes.Color;
import src.piece.attributes.Column;
import src.piece.attributes.Row;
import src.piece.attributes.Type;

/**
 * @author Andrew Matherne
 */
public class Piece {

    private final  Color COLOR;
    private final Type TYPE;

    private Row row;
    private Column column;

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
    public Color color() {
        return COLOR;
    }

    /**
     * Returns the <code>PType</code> attribute of the <code>Piece</code>
     * 
     * @return <code>PType</code>
     */
    public Type type() {
        return TYPE;
    }

    /**
     * Returns the <code>PRow</code> attribute of the <code>Piece</code>
     * 
     * @return <code>PRow</code>
     */
    public Row row() {
        return row;
    }

    /**
     * Returns the <code>PColumn</code> attribute of the <code>Piece</code>
     * 
     * @return <code>PColumn</code>
     */
    public Column column() {
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
