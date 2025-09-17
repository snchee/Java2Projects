
public class Circle extends Ellipse {

    // Constructor
    public Circle(double radius) {
        // Pass the same radius for both semi-major and semi-minor axes to the Ellipse constructor
        super(radius, radius);
        if (radius <= 0) {
            throw new IllegalArgumentException("Nonpositive value(s) provided for the constructor");
        }
    }

    // Getter
    public double getRadius() {
        return getA();
    }
}
