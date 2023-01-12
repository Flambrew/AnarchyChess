package src.game.constructs;

import src.game.constructs.attributes.Column;
import src.game.constructs.attributes.Row;

/**
 * @author Andrew Matherne
 */
public class Move {

    public final Row ROW;
    public final Column COLUMN;

    public final Vector2 TRANSFORM;

    /**
     * Initializes a new Move.
     * 
     * @param startRow
     * @param startColumn
     * @param endRow
     * @param endColumn
     */
    public Move(Row startRow, Column startColumn, Row endRow, Column endColumn) {
        this.ROW = startRow;
        this.COLUMN = startColumn;
        this.TRANSFORM = new Vector2(endColumn.X - startColumn.X, endRow.Y - startRow.Y);
    }

    public String toString() {
        return String.format("(%s%s) -> (%s%s)", COLUMN, ROW, COLUMN.move(TRANSFORM.X), ROW.move(TRANSFORM.Y));
    }
}
