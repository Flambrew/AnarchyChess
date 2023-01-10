package src.piece;

import src.piece.attributes.Column;
import src.piece.attributes.Row;

public class Move {

    private final Row START_ROW;
    private final Row END_ROW;
    private final Column START_COLUMN;
    private final Column END_COLUMN;

    public Move(Row startRow, Column startColumn, Row endRow, Column endColumn) {
        this.START_ROW = startRow;
        this.START_COLUMN = startColumn;
        this.END_ROW = endRow;
        this.END_COLUMN = endColumn;
    }

    public Row startRow() {
        return START_ROW;
    }

    public Row endRow() {
        return END_ROW;
    }

    public Column startColumn() {
        return START_COLUMN;
    }

    public Column endColumn() {
        return END_COLUMN;
    }
}
