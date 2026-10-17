public class DeadlockDemo {
    private static final Object LOCK_A = new Object(), LOCK_B = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread first = new Thread(() -> {
            synchronized (LOCK_A) { System.out.println("First has A"); pause();
                synchronized (LOCK_B) { System.out.println("First has A and B"); } }
        }, "First");
        Thread second = new Thread(() -> {
            synchronized (LOCK_B) { System.out.println("Second has B"); pause();
                synchronized (LOCK_A) { System.out.println("Second has B and A"); } }
        }, "Second");
        first.setDaemon(true); second.setDaemon(true); first.start(); second.start();
        Thread.sleep(100);
        System.out.println("Deadlock may have occurred; daemon threads allow exit.");
        Object low = new Object(), high = new Object();
        Thread safe1 = new Thread(() -> orderedLock(low, high, "Safe-1"));
        Thread safe2 = new Thread(() -> orderedLock(low, high, "Safe-2"));
        safe1.start(); safe2.start(); safe1.join(); safe2.join();
        System.out.println("Consistent lock ordering completed.");
    }
    static void pause() {
        try { Thread.sleep(50); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
    static void orderedLock(Object first, Object second, String name) {
        synchronized (first) { synchronized (second) { System.out.println(name + " acquired locks in same order"); } }
    }
}
