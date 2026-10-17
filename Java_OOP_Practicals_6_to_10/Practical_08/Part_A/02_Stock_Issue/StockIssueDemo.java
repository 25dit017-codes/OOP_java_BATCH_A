public class StockIssueDemo {
    public static void main(String[] args) {
        Stock stock = new Stock();
        int[] requests = {2, 0, 8, 1};
        for (int quantity : requests) {
            try { stock.issue(quantity); }
            catch (OutOfStockException | InvalidQuantityException e) {
                System.out.println("Could not issue: " + e.getMessage());
            }
        }
        System.out.println("Program continued after failed requests.");
    }
}
