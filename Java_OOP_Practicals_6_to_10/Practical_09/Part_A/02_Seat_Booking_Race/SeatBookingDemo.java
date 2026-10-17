public class SeatBookingDemo {
    static class UnsafeBooking {
        int seats = 1;
        void book(String name) {
            if (seats > 0) {
                try { Thread.sleep(20); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                seats--; System.out.println(name + " booked a seat");
            }
        }
    }
    static class SafeBooking {
        int seats = 1;
        synchronized void book(String name) {
            if (seats > 0) { seats--; System.out.println(name + " booked a seat"); }
            else System.out.println(name + " could not book");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        UnsafeBooking unsafe = new UnsafeBooking();
        Thread a = new Thread(() -> unsafe.book("User A"));
        Thread b = new Thread(() -> unsafe.book("User B"));
        a.start(); b.start(); a.join(); b.join();
        System.out.println("Unsafe seats left: " + unsafe.seats);
        SafeBooking safe = new SafeBooking();
        a = new Thread(() -> safe.book("User A")); b = new Thread(() -> safe.book("User B"));
        a.start(); b.start(); a.join(); b.join();
        System.out.println("Safe seats left: " + safe.seats);
    }
}
