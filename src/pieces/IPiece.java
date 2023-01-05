package src.pieces;

public interface IPiece {
    PieceColor getColor();
    PieceType getType();

    boolean legalMove(int toLocation, int fromLocation);
}
