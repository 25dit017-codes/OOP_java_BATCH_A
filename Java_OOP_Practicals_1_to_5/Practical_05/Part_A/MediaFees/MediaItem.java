public abstract class MediaItem {
    protected String title;
    public MediaItem(String title) { this.title = title; }
    public abstract double lateFee(int daysLate);
}
