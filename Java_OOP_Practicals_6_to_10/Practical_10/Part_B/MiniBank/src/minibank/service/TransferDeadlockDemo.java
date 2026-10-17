package minibank.service;

public class TransferDeadlockDemo {
    private static final Object accountA = new Object();
    private static final Object accountB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread first = new Thread(() -> {
            synchronized (accountA) {
                System.out.println("Transfer A-to-B locked A");
                pause();
                synchronized (accountB) { System.out.println("Transfer A-to-B locked B"); }
            }
        }, "A-to-B");
        Thread second = new Thread(() -> {
            synchronized (accountB) {
                System.out.println("Transfer B-to-A locked B");
                pause();
                synchronized (accountA) { System.out.println("Transfer B-to-A locked A"); }
            }
        }, "B-to-A");
        first.setDaemon(true);
        second.setDaemon(true);
        first.start();
        second.start();
        Thread.sleep(100);
        System.out.println("Unsafe transfer example may deadlock (daemon threads allow exit).");

        Object lowerNumberAccount = new Object();
        Object higherNumberAccount = new Object();
        Thread safe1 = new Thread(() -> safeTransfer(lowerNumberAccount, higherNumberAccount, "Safe A-to-B"));
        Thread safe2 = new Thread(() -> safeTransfer(lowerNumberAccount, higherNumberAccount, "Safe B-to-A"));
        safe1.start();
        safe2.start();
        safe1.join();
        safe2.join();
        System.out.println("Safe transfers completed using the same lock order.");
    }

    private static void pause() {
        try { Thread.sleep(50); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    private static void safeTransfer(Object lower, Object higher, String name) {
        synchronized (lower) {
            synchronized (higher) { System.out.println(name + " completed"); }
        }
    }
}
