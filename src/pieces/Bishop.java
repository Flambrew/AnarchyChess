package src.pieces;

public class Bishop extends Piece {

    public Bishop(PieceColor color, PieceType type, int location) {
        super(color, type, location);
    }

    public boolean legalMove(int toLocation, int fromLocation) {
        return false;
    }
}
