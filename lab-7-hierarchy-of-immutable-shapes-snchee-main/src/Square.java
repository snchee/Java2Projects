
public class Square extends Rectangle {

    // Constructor
    public Square(double side) {
        super(side, side);
    }

    // Getter
    public double getSide() {
        return getWidth(); // Since width and height are equal, we can return either
    }
}
