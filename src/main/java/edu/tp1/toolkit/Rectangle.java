package edu.tp1.toolkit;

/** Rectangle immuable (largeur/hauteur >= 0). */
public final class Rectangle {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Dimensions négatives interdites");
        }
        this.width = width;
        this.height = height;
    }

    public double getWidth()  { return width;  }
    public double getHeight() { return height; }

    public double area()      { return width * height; }
    public double perimeter() { return 2 * (width + height); }

    /** Retourne un nouveau rectangle mis à l’échelle (factor >= 0). */
    public Rectangle scale(double factor) {
        if (factor < 0) throw new IllegalArgumentException("factor < 0");
        return new Rectangle(width * factor, height * factor);
    }
}
