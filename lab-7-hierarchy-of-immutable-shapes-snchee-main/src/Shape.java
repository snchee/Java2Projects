
public abstract class Shape implements Comparable<Shape> {

	// TODO: Complete this class.
    private int id;

    private static int nextID = 0;

    // Constructor
    public Shape() {
        this.id = nextID++;
    }

    // Getter
    public int getID() {
        return id;
    }

    public abstract double getPerimeter();
    public abstract double getArea();

    @Override
    public int compareTo(Shape other) {
        // Step 1: Compare by class name alphabetically
        String thisClassName = this.getClass().getName();
        String otherClassName = other.getClass().getName();
        int classNameComparison = thisClassName.compareTo(otherClassName);

        if (classNameComparison != 0) {
            return classNameComparison;
        }

        // Step 2: If same class, compare by perimeter (smallest to largest)
        double perimeterDifference = this.getPerimeter() - other.getPerimeter();
        if (Math.abs(perimeterDifference) > 0.001) {
            return (perimeterDifference > 0) ? 1 : -1;
        }

        // Step 3: If same perimeter, compare by area (smallest to largest)
        double areaDifference = this.getArea() - other.getArea();
        if (Math.abs(areaDifference) > 0.001) {
            return (areaDifference > 0) ? 1 : -1;
        }

        // Step 4: If same class, perimeter, and area, return 0 (keep order)
        return 0;
    }

	@Override
	public String toString() {
		return "<"
				+ getClass().getName()
				+ ", ID: " + id
				+ ", PERIMETER: " + String.format("%.1f", getPerimeter())
				+ ", AREA: " + String.format("%.1f", getArea())
				+ ">";
	}
}