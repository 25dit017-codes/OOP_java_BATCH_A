package minibank.service;

public class UnsynchronizedAccountDemo {
    static class UnsafeAccount {
        private long balance;
        void deposit(long amount) {
            long oldBalance = balance;
            Thread.yield();
            balance = oldBalance + amount;
        }
        long getBalance() { return balance; }
    }

    public static void main(String[] args) throws InterruptedException {
        UnsafeAccount account = new UnsafeAccount();
        Thread[] workers = new Thread[10];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) account.deposit(1);
            });
            workers[i].start();
        }
        for (Thread worker : workers) worker.join();
        System.out.println("Unsynchronized balance (may be below 10000): " + account.getBalance());
        System.out.println("Run ThreadBankDemo to see the synchronized result.");
    }
}
