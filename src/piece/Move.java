package src.piece;

import src.piece.attributes.Column;
import src.piece.attributes.Row;
import src.utils.Vector2;

public class Move {

    public final Row ROW;
    public final Column COLUMN;

    public final Vector2 TRANSFORM;

    public Move(Row startRow, Column startColumn, Row endRow, Column endColumn) {
        this.ROW = startRow;
        this.COLUMN = startColumn;
        this.TRANSFORM = new Vector2(endColumn.X - startColumn.X, endRow.Y - startRow.Y);
    }
}
