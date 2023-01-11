package src.game;

import java.util.ArrayList;

import src.piece.Piece;
import src.piece.attributes.Color;
import src.piece.attributes.Column;
import src.piece.attributes.Row;
import src.piece.attributes.Type;

/**
 * @author Andrew Matherne
 */
public class Board {

    private final ArrayList<Piece> board = new ArrayList<>();
    private final Piece[] DEFAULT_BOARD_SETUP = {
            new Piece(Color.WHITE, Type.ROOK, Row._1, Column.A),
            new Piece(Color.WHITE, Type.KNIGHT, Row._1, Column.B),
            new Piece(Color.WHITE, Type.BISHOP, Row._1, Column.C),
            new Piece(Color.WHITE, Type.QUEEN, Row._1, Column.D),
            new Piece(Color.WHITE, Type.KING, Row._1, Column.E),
            new Piece(Color.WHITE, Type.BISHOP, Row._1, Column.F),
            new Piece(Color.WHITE, Type.KNIGHT, Row._1, Column.G),
            new Piece(Color.WHITE, Type.ROOK, Row._1, Column.H),

            new Piece(Color.WHITE, Type.PAWN, Row._2, Column.A),
            new Piece(Color.WHITE, Type.PAWN, Row._2, Column.B),
            new Piece(Color.WHITE, Type.PAWN, Row._2, Column.C),
            new Piece(Color.WHITE, Type.PAWN, Row._2, Column.D),
            new Piece(Color.WHITE, Type.PAWN, Row._2, Column.E),
            new Piece(Color.WHITE, Type.PAWN, Row._2, Column.F),
            new Piece(Color.WHITE, Type.PAWN, Row._2, Column.G),
            new Piece(Color.WHITE, Type.PAWN, Row._2, Column.H),

            new Piece(Color.BLACK, Type.PAWN, Row._7, Column.A),
            new Piece(Color.BLACK, Type.PAWN, Row._7, Column.B),
            new Piece(Color.BLACK, Type.PAWN, Row._7, Column.C),
            new Piece(Color.BLACK, Type.PAWN, Row._7, Column.D),
            new Piece(Color.BLACK, Type.PAWN, Row._7, Column.E),
            new Piece(Color.BLACK, Type.PAWN, Row._7, Column.F),
            new Piece(Color.BLACK, Type.PAWN, Row._7, Column.G),
            new Piece(Color.BLACK, Type.PAWN, Row._7, Column.H),

            new Piece(Color.BLACK, Type.ROOK, Row._8, Column.A),
            new Piece(Color.BLACK, Type.KNIGHT, Row._8, Column.B),
            new Piece(Color.BLACK, Type.BISHOP, Row._8, Column.C),
            new Piece(Color.BLACK, Type.QUEEN, Row._8, Column.D),
            new Piece(Color.BLACK, Type.KING, Row._8, Column.E),
            new Piece(Color.BLACK, Type.BISHOP, Row._8, Column.F),
            new Piece(Color.BLACK, Type.KNIGHT, Row._8, Column.G),
            new Piece(Color.BLACK, Type.ROOK, Row._8, Column.H)
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
    public Piece get(Row row, Column column) {
        for (Piece piece : board)
            if (piece.ROW == row && piece.COLUMN == column)
                return piece;
        return null;
    }

    /**
     * Return ArrayList of all Pieces of specified PType
     * 
     * @param type
     * @return ArrayList of Piece
     */
    public ArrayList<Piece> getAll(Type type) {
        ArrayList<Piece> all = new ArrayList<Piece>();
        for (Piece piece : board)
            if (piece.TYPE == type)
                all.add(piece);
        return all;
    }

    /**
     * Return ArrayList of all Pieces of specified PColor
     * 
     * @param color
     * @return ArrayList of Piece
     */
    public ArrayList<Piece> getAll(Color color) {
        ArrayList<Piece> all = new ArrayList<Piece>();
        for (Piece piece : board)
            if (piece.COLOR == color)
                all.add(piece);
        return all;
    }

    /**
     * Returns the Board.board ArrayList
     * 
     * @return ArrayList of Piece
     */
    public ArrayList<Piece> board() {
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
                    if (piece.ROW.num == i && piece.COLUMN.num == j) {
                        out += piece + " ";
                        break;
                    } else if (piece == board.get(board.size() - 1))
                        out += " * ";
        return out.substring(0, out.length() - 1);
    }
}