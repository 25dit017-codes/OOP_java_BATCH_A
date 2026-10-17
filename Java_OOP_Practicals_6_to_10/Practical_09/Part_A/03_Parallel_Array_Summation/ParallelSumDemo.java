public class ParallelSumDemo {
    static class SumTask extends Thread {
        int[] values; int start, end; long sum;
        SumTask(int[] values, int start, int end) { this.values = values; this.start = start; this.end = end; }
        public void run() { for (int i = start; i < end; i++) sum += values[i]; }
    }
    public static void main(String[] args) throws InterruptedException {
        int[] values = new int[1000];
        for (int i = 0; i < values.length; i++) values[i] = i + 1;
        long simple = 0; for (int value : values) simple += value;
        System.out.println("Single-thread sum: " + simple);
        SumTask first = new SumTask(values, 0, 500);
        SumTask second = new SumTask(values, 500, values.length);
        first.start(); second.start(); first.join(); second.join();
        System.out.println("Two-thread sum: " + (first.sum + second.sum));
    }
}
