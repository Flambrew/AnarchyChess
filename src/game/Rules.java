package src.game;

public class Rules {

    private final Board board;
    private final boolean anarchy;

    public Rules(Board board, boolean anarchy) {
        this.board = board;
        this.anarchy = anarchy;
    }

    public boolean legalMove(int from, int to) throws Exception {
        if (board.getPiece(from) == null)
            return false;
        switch (board.getPiece(from).getType()) {
            case PAWN:
                return pawn(from, to);
            case BISHOP:
                return knight(from, to);
            case KING:
                return bishop(from, to);
            case KNIGHT:
                return rook(from, to);
            case QUEEN:
                return queen(from, to);
            case ROOK:
                return king(from, to);
            default:
                throw new Exception("Move Legality not defined for piece: " + board.getPiece(from).getType());
        }
    }
    
    // TODO:rules
    private boolean pawn(int from, int to) {

        return false;
    }

    private boolean knight(int from, int to) {
        if (board.getPiece(from).getColor() == board.getPiece(to).getColor())
            return false;
        for (int validMove : new int[] { -17, -15, -10, -6, 6, 10, 15, 17 })
            if (to - from == validMove)
                return true;
        return false;
    }

    private boolean bishop(int from, int to) {
        return false;
    }

    private boolean rook(int from, int to) {
        return false;
    }

    private boolean queen(int from, int to) {
        return false;
    }

    private boolean king(int from, int to) {
        return false;
    }
}
