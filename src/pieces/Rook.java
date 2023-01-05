package src.pieces;

public class Rook extends Piece {

    public Rook(PieceColor color, PieceType type, int location) {
        super(color, type, location);
    }
    
    public boolean legalMove(int toLocation, int fromLocation) {
        return false;
    }
}
