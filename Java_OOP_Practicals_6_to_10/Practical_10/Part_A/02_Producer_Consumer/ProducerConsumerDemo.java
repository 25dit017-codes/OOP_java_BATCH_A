public class ProducerConsumerDemo {
    static class Buffer {
        private int item; private boolean available;
        public synchronized void put(int value) throws InterruptedException {
            while (available) wait();
            item = value; available = true;
            System.out.println("Produced: " + value); notify();
        }
        public synchronized int take() throws InterruptedException {
            while (!available) wait();
            int value = item; available = false;
            System.out.println("Consumed: " + value); notify(); return value;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer();
        Thread producer = new Thread(() -> {
            try { for (int i = 1; i <= 5; i++) buffer.put(i); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        Thread consumer = new Thread(() -> {
            try { for (int i = 1; i <= 5; i++) buffer.take(); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        producer.start(); consumer.start(); producer.join(); consumer.join();
    }
}
