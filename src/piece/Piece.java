package src.piece;

public class Piece {
    
    private final PieceColor COLOR;
    private final PieceType TYPE;

    public Piece(PieceColor color, PieceType type) {
        this.COLOR = color;
        this.TYPE = type;
    }

    public Piece(Piece other) {
        this.COLOR = other.COLOR;
        this.TYPE = other.TYPE;
    }

    public PieceColor getColor() {
        return COLOR;
    }

    public PieceType getType() {
        return TYPE;
    }
    
    public String toString() {
        return Integer.toString(COLOR.sign * TYPE.num);
    }
}
