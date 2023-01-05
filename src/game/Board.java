package src.game;

import java.util.ArrayList;
import java.util.List;

import src.piece.Piece;
import src.piece.PieceColor;
import src.piece.PieceType;

public class Board {

    private final Piece[] board = new Piece[64];

    public Board() {
        boardSetup();
    }

    public Piece getPiece(int location) {
        return board[location];
    }

    public void setPiece(Piece piece, int location) {
        board[location] = piece;
    }

    public int[] findPiece(PieceType type) {
        List<Integer> pieceLocations = new ArrayList<Integer>();
        for (int i = 0; i < board.length; i++)
            if (board[i].getType() == type)
                pieceLocations.add(i);
        return pieceLocations.stream().mapToInt(Integer::intValue).toArray();
    }

    public void movePiece(int from, int to) {
        board[to] = board[from];
        board[from] = null;
    }

    private void boardSetup() {
        for (int i = 0; i < 64; i++)
            board[i] = new Piece(PieceColor.NONE, PieceType.NONE);

        for (int i : new int[] { 48, 49, 50, 51, 52, 53, 54, 55 })
            board[i] = new Piece(PieceColor.WHITE, PieceType.PAWN);
        for (int i : new int[] { 57, 62 })
            board[i] = new Piece(PieceColor.WHITE, PieceType.KNIGHT);
        for (int i : new int[] { 58, 61 })
            board[i] = new Piece(PieceColor.WHITE, PieceType.BISHOP);
        for (int i : new int[] { 56, 63 })
            board[i] = new Piece(PieceColor.WHITE, PieceType.ROOK);
        board[59] = new Piece(PieceColor.WHITE, PieceType.QUEEN);
        board[60] = new Piece(PieceColor.WHITE, PieceType.KING);

        for (int i : new int[] { 8, 9, 10, 11, 12, 13, 14, 15 })
            board[i] = new Piece(PieceColor.BLACK, PieceType.PAWN);
        for (int i : new int[] { 1, 6 })
            board[i] = new Piece(PieceColor.BLACK, PieceType.KNIGHT);
        for (int i : new int[] { 2, 5 })
            board[i] = new Piece(PieceColor.BLACK, PieceType.BISHOP);
        for (int i : new int[] { 0, 7 })
            board[i] = new Piece(PieceColor.BLACK, PieceType.ROOK);
        board[3] = new Piece(PieceColor.BLACK, PieceType.QUEEN);
        board[4] = new Piece(PieceColor.BLACK, PieceType.KING);
    }

    public String toString() {
        String out = "";
        for (int i = 0; i < 8; i++, out += "\n")
            for (int j = 0; j < 8; j++, out += "\t")
                out += board[i * 8 + j];
        return out;
    }
}
