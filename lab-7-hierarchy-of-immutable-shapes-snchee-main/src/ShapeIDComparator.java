import java.util.Comparator;

public class ShapeIDComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape s1, Shape s2) {
        // Compare the IDs of the two shapes
        return Integer.compare(s1.getID(), s2.getID());
    }
}
