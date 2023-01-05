package src.piece;

public enum PieceColor {
    NONE(0),
    WHITE(1),
    BLACK(-1);
    
    int sign;

    PieceColor(int sign) {
        this.sign = sign;
    }
}
