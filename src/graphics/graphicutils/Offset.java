package src.graphics.graphicutils;

/**
 * I hate that this class exists. For some reason, every single window is
 * missing 16 pixels on its x axis and 39 pixels on its y axis and it makes no
 * goddamn sense. As a result, I must make this ridiculous class to offset that
 * in certain places.
 * 
 * @author Andrew Matherne
 */
public class Offset {
    public static final int X = -8;
    public static final int Y = -19;
}
