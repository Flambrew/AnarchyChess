package src.game;

import java.util.ArrayList;

import src.piece.Piece;
import src.piece.PColor;
import src.piece.PType;

/**
 * @author Andrew Matherne
 */
public class Board {

    private final ArrayList<Piece> board = new ArrayList<>();

    /**
     * Initializes a new <code>Board</code> with preset <code>Piece</code> objects
     * matching a given array of positions, if empty, matching the official chess
     * piece starting positions
     *
     * @param pieceList 2D array of <code>Piece</code>
     */
    public Board(Piece... pieceList) {
        boardSetup(pieceList);
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
        return null;
    }

    public ArrayList<Piece> getAll(PColor color) {
        return null;
    }

    public ArrayList<Piece> getAll(PType type, PColor color) {
        return null;
    }

    public ArrayList<Piece> getBoard() {
        return null;
    }

    public void boardSetup(Piece... pieceList) {
        // empty is default
    }

    public String toString() {
        return null;
    }

}
