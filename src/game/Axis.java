package src.game;

public enum Axis {
    CARDINAL(-8, -1, 1, 8),
    DIAGONAL(-9, -7, 7, 9);

    int[] directions;

    Axis(int... directions) {
        this.directions = directions;
    }
}
