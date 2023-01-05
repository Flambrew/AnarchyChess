package src.pieces;

public class Pawn extends Piece {

    public Pawn(PieceColor color, PieceType type) {
        super(color, type);
    }

    public boolean legalMove() {
        return false;
    }
}
