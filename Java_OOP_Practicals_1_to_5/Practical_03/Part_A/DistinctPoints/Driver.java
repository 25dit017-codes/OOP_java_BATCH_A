import java.util.HashSet;
import java.util.Set;

public class Driver {
    public static void main(String[] args) {
        Point[] points = {new Point(1, 2), new Point(2, 3), new Point(1, 2), new Point(4, 5)};
        Set<Point> distinct = new HashSet<>();
        for (Point point : points) {
            System.out.println(point);
            distinct.add(point);
        }
        System.out.println("Distinct coordinates: " + distinct.size());
    }
}
