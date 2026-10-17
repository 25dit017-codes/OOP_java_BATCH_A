package discount;
public class DiscountEngine {
    public double finalPrice(double price, DiscountRule rule) { return rule.apply(price); }
}
