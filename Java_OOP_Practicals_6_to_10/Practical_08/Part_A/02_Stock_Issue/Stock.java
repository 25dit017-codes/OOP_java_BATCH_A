public class Stock {
    private int available = 5;
    public void issue(int quantity) throws OutOfStockException, InvalidQuantityException {
        if (quantity <= 0) throw new InvalidQuantityException("Quantity must be positive.");
        if (quantity > available) throw new OutOfStockException("Not enough stock available.");
        available -= quantity;
        System.out.println("Issued " + quantity + " item(s). Remaining: " + available);
    }
}
