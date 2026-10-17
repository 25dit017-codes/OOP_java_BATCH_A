public class MediaFeeDemo {
    public static void main(String[] args) {
        MediaItem[] items = {new Book("Java Basics"), new DVD("Learning Java")};
        for (MediaItem item : items) {
            System.out.println(item.title + " late fee for 3 days: Rs. " + item.lateFee(3));
        }
    }
}
