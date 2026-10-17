public class Book extends MediaItem {
    public Book(String title) { super(title); }
    @Override public double lateFee(int daysLate) { return Math.max(0, daysLate) * 2.0; }
}
