public class ShapeDemo {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(3), new Rectangle(4, 5), new Triangle(6, 4)
        };
        double total = 0, largest = 0;
        for (Shape shape : shapes) {
            double area = shape.area();
            System.out.printf("%s area = %.2f%n", shape.getClass().getSimpleName(), area);
            total += area;
            if (area > largest) largest = area;
        }
        System.out.printf("Total area = %.2f%nLargest area = %.2f%n", total, largest);
    }
}
