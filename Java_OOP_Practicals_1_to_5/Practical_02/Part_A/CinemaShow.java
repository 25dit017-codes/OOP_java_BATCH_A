public class CinemaShow {
    private String title;
    private int capacity;
    private int availableSeats;
    private static int totalBookings = 0;

    public CinemaShow(String title, int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity cannot be negative");
        this.title = title;
        this.capacity = capacity;
        this.availableSeats = capacity;
    }

    public boolean book(int n) {
        if (n <= 0 || n > availableSeats) return false;
        availableSeats -= n;
        totalBookings += n;
        return true;
    }

    public boolean cancel(int n) {
        if (n <= 0 || n > capacity - availableSeats) return false;
        availableSeats += n;
        totalBookings -= n;
        return true;
    }

    public String getTitle() { return title; }
    public int getAvailableSeats() { return availableSeats; }
    public static int getTotalBookings() { return totalBookings; }

    public static void main(String[] args) {
        CinemaShow show = new CinemaShow("Java: The Movie", 100);
        System.out.println("Book 5: " + show.book(5));
        System.out.println("Book 200: " + show.book(200));
        System.out.println("Cancel 2: " + show.cancel(2));
        System.out.println("Available seats: " + show.getAvailableSeats());
        System.out.println("Total bookings: " + getTotalBookings());
    }
}
