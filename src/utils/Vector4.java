package src.utils;

/**
 * @author Andrew Matherne
 */
public class Vector4 {

    public final int W, X, Y, Z;
    public final double w, x, y, z;

    /**
     * Initializes a new Vector4.
     * 
     * @param w
     * @param x
     * @param y
     * @param z
     */
    public Vector4(double w, double x, double y, double z) {
        this.W = (int)w;
        this.X = (int)x;
        this.Y = (int)y;
        this.Z = (int)z;
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
