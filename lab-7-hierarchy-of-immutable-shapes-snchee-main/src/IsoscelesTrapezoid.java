
public class IsoscelesTrapezoid extends Polygon {

    private double top;
    private double base;
    private double leg;
    private double height;
    private double area;

    // Constructor
    public IsoscelesTrapezoid(double top, double base, double leg) {
        super(top, base, leg, leg);

        this.top = top;
        this.base = base;
        this.leg = leg;

        // Calculating the height
        this.height = Math.sqrt(leg * leg - Math.pow((base - top) / 2.0, 2));

        // Calculating the area
        this.area = (top + base) * height / 2.0;
    }

    // Getters
    public double getTop() {
        return top;
    }

    public double getBase() {
        return base;
    }

    public double getLeg() {
        return leg;
    }

    // Getter for the center rectangle
    public Rectangle getCenterRectangle() {
        if (top < base) {
        	return new Rectangle(top, height);
        } else {
        	return new Rectangle(base, height);
        }
    }

    // Override the abstract method to get the area
    @Override
    public double getArea() {
        return area;
    }
}