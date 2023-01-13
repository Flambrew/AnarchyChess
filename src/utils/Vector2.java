package src.utils;

/**
 * @author Andrew Matherne
 */
public class Vector2 {

    public final int X, Y;
    public final double x, y;

    /**
     * Initializes a new Vector2.
     * 
     * @param x
     * @param y
     */
    public Vector2(double x, double y) {
        this.X = (int)x;
        this.Y = (int)y;
        this.x = x;
        this.y = y;
    }
}
