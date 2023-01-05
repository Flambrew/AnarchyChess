package src.game;

import java.util.ArrayList;
import java.util.List;

import src.piece.Piece;
import src.piece.PieceColor;
import src.piece.PieceType;

/**
 * @author Andrew Matherne
 */
public class Board {

    private final Piece[] board = new Piece[64];

    /**
     * Initializes a new <code>Board</code> with preset <code>Piece</code> objects
     * matching the official chess piece starting positions.
     */
    public Board() {
        boardSetup();
    }

    /**
     * Initializes a new <code>Board</code> with preset <code>Piece</code> objects
     * matching a given array of positions.
     *
     * @param positions 2D array of <code>Piece</code>
     * @param pieceList Order in which the rows of the given array refer to
     *                  <code>Piece</code> types
     */
    public Board(int[][] positionList, Piece[] pieceList) {
        boardSetup(positionList, pieceList);
    }

    /**
     * Returns a <code>Piece</code> from the board given a position.
     * 
     * @param position
     * @return <code>Piece</code> at <code>position</code>
     */
    public Piece getPiece(int position) {
        return board[position];
    }

    /**
     * Sets a position on the board to a certain <code>Piece</code>.
     * 
     * @param piece
     * @param position
     */
    public void setPiece(Piece piece, int position) {
        board[position] = piece;
    }

    /**
     * Returns an array containing positions of all <code>Piece</code> objects with
     * a given <code>PieceColor</code> and <code>PieceType</code>.
     * 
     * @param color
     * @param type
     * @return <code>Piece[]</code>
     */
    public int[] findPiece(PieceColor color, PieceType type) {
        List<Integer> piecePositions = new ArrayList<Integer>();
        for (int i = 0; i < board.length; i++)
            if (board[i].getColor() == color && board[i].getType() == type)
                piecePositions.add(i);
        return piecePositions.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Moves a <code>Piece</code> from one position to another, overriding the contents of the destination position
     * 
     * @param from
     * @param to
     */
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

    private void boardSetup(int[][] positionList, Piece[] pieceList) {
        if (positionList.length != pieceList.length)
            throw new IllegalArgumentException("Board Setup Error: pieceList and positionList lengths do not match.");
        for (int i = 0; i < 64; i++)
            board[i] = new Piece(PieceColor.NONE, PieceType.NONE);
        for (int i = 0; i < pieceList.length; i++)
            for (int j = 0; j < positionList[i].length; j++)
                board[positionList[i][j]] = new Piece(pieceList[i]);
    }

    public String toString() {
        String out = "";
        for (int i = 0; i < 8; i++, out += "\n")
            for (int j = 0; j < 8; j++, out += "\t")
                out += board[i * 8 + j];
        return out;
    }
}
