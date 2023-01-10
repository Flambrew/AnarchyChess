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
     * Initializes a new <code>Board</code> with preset <code>Piece</code> objects
     * matching a given array of positions, if empty, matching the official chess
     * piece starting positions
     *
     * @param pieceList 2D array of <code>Piece</code>
     */
    public Board(Piece... pieceList) {
        setup(pieceList);
    }

    /**
     * Copy constructor for <code>Board</code>
     * 
     * @param other
     */
    public Board(Board other) {
        for (Piece piece : other.board)
            board.add(piece);
    }

    public ArrayList<Piece> getAll(PType type) {
        ArrayList<Piece> all = new ArrayList<Piece>();
        for (Piece piece : board)
            if (piece.getType() == type)
                all.add(piece);
        return all;
    }

    public ArrayList<Piece> getAll(PColor color) {
        ArrayList<Piece> all = new ArrayList<Piece>();
        for (Piece piece : board)
            if (piece.getColor() == color)
                all.add(piece);
        return all;
    }

    public ArrayList<Piece> getBoard() {
        return board;
    }

    public void setup(Piece... pieceList) {
        if (pieceList == null || pieceList.length == 0)
            pieceList = DEFAULT_BOARD_SETUP;
        for (Piece piece : pieceList)
            board.add(piece);
    }

    public String toString() {
        String out = "";
        for (int i = 7; i >= 0; i--, out += "\n") {
            for (int j = 0; j < 8; j++, out += "\t")
                for (Piece piece : board) {
                    if (piece.getRow().num == i && piece.getColumn().num == j) {
                        System.out.print(piece + " ");
                        break;
                    }
                    if (piece == board.get(board.size() - 1))
                        System.out.print(" * ");
                }
            System.out.println();
        }
        return out;
    }
}