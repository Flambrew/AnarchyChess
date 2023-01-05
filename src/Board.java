package src;

import java.util.ArrayList;
import java.util.List;

import src.pieces.Piece;
import src.pieces.PieceColor;
import src.pieces.PieceType;

public class Board {
    
    private final Piece[] board = new Piece[64];

    public Piece getPiece(int location) {
        return board[location];
    }

    public void setPiece(Piece piece, int location) {
        board[location] = piece;
    }

    public int[] findPiece(Class<?> type) {
        List<Integer> pieceLocations = new ArrayList<Integer>();
        for (int i = 0; i < board.length; i++) {
            if (type.isInstance(board[i])) {
                pieceLocations.add(i);
            }
        }
        return pieceLocations.stream().mapToInt(Integer::intValue).toArray();
    }

    public Board() {
        
    }

    public void addPiece(PieceColor color, PieceType type, int location) {

    }

    public void movePiece(int fromLocation, int toLocation) {
        board[toLocation] = board[fromLocation];
        board[fromLocation] = null;
        // board[toLocation].setLocation(fromLocation);

        // TODO: figure out how tf i wanna implement move rules
        // ideas- every piece has location, move check
        //        all the move checks happen in Board
        //        new ChessRules class that somehow interfaces with Board
    }
}
