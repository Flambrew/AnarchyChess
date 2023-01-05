package src.pieces;

public class Queen extends Piece {

    public Queen(PieceColor color, PieceType type, int location) {
        super(color, type, location);
    }
    
    public boolean legalMove(int toLocation, int fromLocation) {
        return false;
    }
}
