package src.piece;

import src.piece.attributes.Column;
import src.piece.attributes.Row;

public class Move {

    public final Row ROW;
    public final Column COLUMN;

    public final int X, Y;

    public Move(Row startRow, Column startColumn, Row endRow, Column endColumn) {
        this.ROW = startRow;
        this.COLUMN = startColumn;
        this.X = endColumn.num - startColumn.num;
        this.Y = endRow.num - startRow.num;
    }
}
