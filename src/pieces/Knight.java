package src.pieces;

public class Knight extends Piece {

    public Knight(PieceColor color, PieceType type, int location) {
        super(color, type, location);
    }

    public boolean legalMove(int toLocation, int fromLocation) {
        return false;
    }
}
