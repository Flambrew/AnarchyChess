package src.pieces;

public class Piece implements IPiece {
    
    private final PieceColor COLOR;
    private final PieceType TYPE;

    private int location;

    public Piece(PieceColor color, PieceType type, int location) {
        this.COLOR = color;
        this.TYPE = type;
        
        this.location = location;
    }

    public PieceColor getColor() {
        return COLOR;
    }

    public PieceType getType() {
        return TYPE;
    }

    public boolean legalMove(int toLocation, int fromLocation) {
        return false;
    }
}
