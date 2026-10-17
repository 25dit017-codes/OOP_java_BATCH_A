public class DVD extends MediaItem {
    public DVD(String title) { super(title); }
    @Override public double lateFee(int daysLate) { return Math.max(0, daysLate) * 5.0; }
}
