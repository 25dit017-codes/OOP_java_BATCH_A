package discount;
public class Main {
    public static void main(String[] args) {
        DiscountEngine engine = new DiscountEngine();
        DiscountRule tenPercent = price -> price - price * 0.10;
        DiscountRule student = price -> price - 100;
        System.out.println("10% discount: " + engine.finalPrice(1000, tenPercent));
        System.out.println("Student discount: " + engine.finalPrice(1000, student));
    }
}
