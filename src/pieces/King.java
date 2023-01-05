package src.pieces;

public class King extends Piece {

    public King(PieceColor color, PieceType type, int location) {
        super(color, type, location);
    }
    
    public boolean legalMove(int toLocation, int fromLocation) {
        return false;
    }
}
