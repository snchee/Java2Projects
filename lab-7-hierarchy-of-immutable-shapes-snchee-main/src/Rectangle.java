
public class Rectangle extends IsoscelesTrapezoid {

    // Constructor
    public Rectangle(double width, double height) {
        super(width, width, height);
    }

    // Getters
    public double getWidth() {
        return getTop();
    }
    
    public double getHeight() {
        return getLeg();
    }
}
