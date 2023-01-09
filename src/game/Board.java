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

    private final ArrayList<Piece> board = new ArrayList<>();

    /**
     * Initializes a new <code>Board</code> with preset <code>Piece</code> objects
     * matching the official chess piece starting positions
     */
    public Board() {
        boardSetup();
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

    /**
     * Initializes a new <code>Board</code> with preset <code>Piece</code> objects
     * matching a given array of positions
     *
     * @param pieceList 2D array of <code>Piece</code>
     */
    public Board(Piece[] pieceList) {
        boardSetup(pieceList);
    }

    public Piece[] getAll(PieceType type) {
        return null;
    }

    public Piece[] getAll(PieceColor color) {
        return null;
    }

    public Piece[] getAll(PieceType type, PieceColor color) {
        return null;
    }

    public Piece[] getBoard() {
        return null;
    }

    public void boardSetup(Piece[] pieceList) {
        // empty is default
    }

    public String toString() {
        return null;
    }

}
