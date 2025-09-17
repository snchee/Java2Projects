
public abstract class Polygon extends Shape {

    private double perimeter;

    // Constructor that accepts an array of side lengths
    public Polygon(double... sides) {
        if (sides == null) {
            throw new IllegalArgumentException("null sides");
        }
        if (sides.length < 3) {
            throw new IllegalArgumentException("Invalid number of sides: " + sides.length);
        }
        for (double side : sides) {
            if (side <= 0) {
                throw new IllegalArgumentException("Nonpositive side: " + side);
            }
        }

        // Validate polygon inequality (sum of any n-1 sides must be greater than the nth side)
        for (int i = 0; i < sides.length; i++) {
            double sumOtherSides = 0;
            for (int j = 0; j < sides.length; j++) {
                if (i != j) {
                    sumOtherSides += sides[j];
                }
            }
            if (sides[i] >= sumOtherSides) {
                throw new IllegalArgumentException("Polygon inequality violated: " + sides[i] + " >= " + sumOtherSides);
            }
        }

        // Calculate the perimeter
        for (double side : sides) {
            perimeter += side;
        }
    }

    // Override the getPerimeter method to return the perimeter of the polygon
    @Override
    public double getPerimeter() {
        return perimeter;
    }
    public abstract double getArea();
}
