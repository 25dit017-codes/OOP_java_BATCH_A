public class CounterRaceDemo {
    static class Counter {
        int value;
        void increment() { int old = value; Thread.yield(); value = old + 1; }
    }
    static class SafeCounter {
        int value;
        synchronized void increment() { value++; }
    }
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> { for (int j = 0; j < 10000; j++) counter.increment(); });
            threads[i].start();
        }
        for (Thread t : threads) t.join();
        System.out.println("Unsynchronized result (may be below 50000): " + counter.value);
        SafeCounter safe = new SafeCounter();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> { for (int j = 0; j < 10000; j++) safe.increment(); });
            threads[i].start();
        }
        for (Thread t : threads) t.join();
        System.out.println("Synchronized result: " + safe.value);
    }
}
