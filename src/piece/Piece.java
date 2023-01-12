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

    private boolean passantable;
    private boolean hasBeenMoved;

    /**
     * Initializes a new Piece.
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
     * Copy constructor for Piece.
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
     * Returns whether the Piece has been moved or not.
     * 
     * @return boolean
     */
    public boolean hasBeenMoved() {
        return hasBeenMoved;
    }

    /**
     * Returns whether the Piece is passantable.
     * 
     * @return boolean
     */
    public boolean passantable() {
        return passantable;
    }

    /**
     * Sets Piece.passantable to true.
     */
    public void setPassantable(boolean passantable) {
        this.passantable = passantable;
    }

    /**
     * Moves the Piece given a Move
     * 
     * @param move
     */
    public void move(Move move) {
        ROW = ROW.move(move.TRANSFORM.Y);
        COLUMN = COLUMN.move(move.TRANSFORM.X);
        hasBeenMoved = true;
    }
    
    public String toString() {
        return (COLOR.sign * TYPE.num > 0 ? " " : "") + Integer.toString(COLOR.sign * TYPE.num);
    }
}
