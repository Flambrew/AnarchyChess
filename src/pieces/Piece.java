package src.pieces;

public class Piece {
    
    private final PieceColor color;
    private final PieceType type;

    public Piece(PieceColor color, PieceType type) {
        this.color = color;
        this.type = type;
    }

    public PieceColor getColor() {
        return color;
    }

    public PieceType getType() {
        return type;
    }
}
