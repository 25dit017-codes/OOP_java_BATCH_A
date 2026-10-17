import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 10; i++) {
            final int task = i;
            pool.execute(() -> System.out.println("Task " + task + " run by " + Thread.currentThread().getName()));
        }
        pool.shutdown();
    }
}
