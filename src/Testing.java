package src;

import src.pieces.Pawn;
import src.pieces.Piece;
import src.pieces.PieceColor;
import src.pieces.PieceType;

public class Testing {
    public static void main(String[] args) {
        Piece p = new Pawn(PieceColor.WHITE, PieceType.PAWN, 0);
        System.out.printf("%s %s", p.getColor(), p.getType());
    }
}
