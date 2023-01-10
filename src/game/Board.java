package src.game;

import java.util.ArrayList;

import src.piece.Piece;
import src.piece.PColor;
import src.piece.PColumn;
import src.piece.PRow;
import src.piece.PType;

/**
 * @author Andrew Matherne
 */
public class Board {

    private final ArrayList<Piece> board = new ArrayList<>();
    private final Piece[] DEFAULT_BOARD_SETUP = {
            new Piece(PColor.WHITE, PType.ROOK, PRow._1, PColumn.A),
            new Piece(PColor.WHITE, PType.KNIGHT, PRow._1, PColumn.B),
            new Piece(PColor.WHITE, PType.BISHOP, PRow._1, PColumn.C),
            new Piece(PColor.WHITE, PType.QUEEN, PRow._1, PColumn.D),
            new Piece(PColor.WHITE, PType.KING, PRow._1, PColumn.E),
            new Piece(PColor.WHITE, PType.BISHOP, PRow._1, PColumn.F),
            new Piece(PColor.WHITE, PType.KNIGHT, PRow._1, PColumn.G),
            new Piece(PColor.WHITE, PType.ROOK, PRow._1, PColumn.H),

            new Piece(PColor.WHITE, PType.PAWN, PRow._2, PColumn.A),
            new Piece(PColor.WHITE, PType.PAWN, PRow._2, PColumn.B),
            new Piece(PColor.WHITE, PType.PAWN, PRow._2, PColumn.C),
            new Piece(PColor.WHITE, PType.PAWN, PRow._2, PColumn.D),
            new Piece(PColor.WHITE, PType.PAWN, PRow._2, PColumn.E),
            new Piece(PColor.WHITE, PType.PAWN, PRow._2, PColumn.F),
            new Piece(PColor.WHITE, PType.PAWN, PRow._2, PColumn.G),
            new Piece(PColor.WHITE, PType.PAWN, PRow._2, PColumn.H),

            new Piece(PColor.BLACK, PType.PAWN, PRow._7, PColumn.A),
            new Piece(PColor.BLACK, PType.PAWN, PRow._7, PColumn.B),
            new Piece(PColor.BLACK, PType.PAWN, PRow._7, PColumn.C),
            new Piece(PColor.BLACK, PType.PAWN, PRow._7, PColumn.D),
            new Piece(PColor.BLACK, PType.PAWN, PRow._7, PColumn.E),
            new Piece(PColor.BLACK, PType.PAWN, PRow._7, PColumn.F),
            new Piece(PColor.BLACK, PType.PAWN, PRow._7, PColumn.G),
            new Piece(PColor.BLACK, PType.PAWN, PRow._7, PColumn.H),

            new Piece(PColor.BLACK, PType.ROOK, PRow._8, PColumn.A),
            new Piece(PColor.BLACK, PType.KNIGHT, PRow._8, PColumn.B),
            new Piece(PColor.BLACK, PType.BISHOP, PRow._8, PColumn.C),
            new Piece(PColor.BLACK, PType.QUEEN, PRow._8, PColumn.D),
            new Piece(PColor.BLACK, PType.KING, PRow._8, PColumn.E),
            new Piece(PColor.BLACK, PType.BISHOP, PRow._8, PColumn.F),
            new Piece(PColor.BLACK, PType.KNIGHT, PRow._8, PColumn.G),
            new Piece(PColor.BLACK, PType.ROOK, PRow._8, PColumn.H)
    };

    /**
     * Initializes a new Board with preset Piece objects matching a given array of
     * positions, if empty, matching the official chess piece starting positions
     *
     * @param pieceList 2D array of Piece
     */
    public Board(Piece... pieceList) {
        setup(pieceList);
    }

    /**
     * Copy constructor for Board
     * 
     * @param other
     */
    public Board(Board other) {
        for (Piece piece : other.board)
            board.add(piece);
    }

    /**
     * Return the Piece at the specified PRow and PColumn
     * 
     * @param row
     * @param column
     * @return Piece
     */
    public Piece get(PRow row, PColumn column) {
        for (Piece piece : board)
            if (piece.getRow() == row && piece.getColumn() == column)
                return piece;
        return null;
    }

    /**
     * Return ArrayList of all Pieces of specified PType
     * 
     * @param type
     * @return ArrayList of Piece
     */
    public ArrayList<Piece> getAll(PType type) {
        ArrayList<Piece> all = new ArrayList<Piece>();
        for (Piece piece : board)
            if (piece.getType() == type)
                all.add(piece);
        return all;
    }

    /**
     * Return ArrayList of all Pieces of specified PColor
     * 
     * @param color
     * @return ArrayList of Piece
     */
    public ArrayList<Piece> getAll(PColor color) {
        ArrayList<Piece> all = new ArrayList<Piece>();
        for (Piece piece : board)
            if (piece.getColor() == color)
                all.add(piece);
        return all;
    }

    /**
     * Returns the Board.board ArrayList
     * 
     * @return ArrayList of Piece
     */
    public ArrayList<Piece> getBoard() {
        return board;
    }

    private void setup(Piece... pieceList) {
        if (pieceList == null || pieceList.length == 0)
            pieceList = DEFAULT_BOARD_SETUP;
        for (Piece piece : pieceList)
            board.add(piece);
    }

    public String toString() {
        String out = "";
        for (int i = 7; i >= 0; i--, out += "\n")
            for (int j = 0; j < 8; j++)
                for (Piece piece : board)
                    if (piece.getRow().num == i && piece.getColumn().num == j) {
                        out += piece + " ";
                        break;
                    } else if (piece == board.get(board.size() - 1))
                        out += " * ";
        return out.substring(0, out.length() - 1);
    }
}