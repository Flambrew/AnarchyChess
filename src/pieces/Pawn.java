package src.pieces;

public class Pawn extends Piece {

    public Pawn(PieceColor color, PieceType type, int location) {
        super(color, type, location);
    }

    public boolean legalMove(int toLocation, int fromLocation) {
        return false;
    }
}
