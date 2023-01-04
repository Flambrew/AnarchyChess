import java.util.ArrayList;
import java.util.List;

public class Board {
    
    Piece[] board;

    public Piece[] getBoard() {
        return board;
    }

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
        return pieceLocations.stream().mapToInt(Integer::intValue).toArray();;
    }
}
