import java.util.ArrayList;
import java.util.List;

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

    public void movePiece(int fromLocation, int toLocation) {
        board[toLocation] = board[fromLocation];
        board[fromLocation] = null;
    }
}
