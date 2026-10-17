package minibank.service;
import minibank.model.Account;
public class ThreadBankDemo {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(0);
        Thread[] workers = new Thread[10];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Thread(new AccountWorker(account, 1000, 1), "Worker-" + (i + 1));
            workers[i].start();
        }
        for (Thread worker : workers) worker.join();
        System.out.println("Final balance: ₹" + account.getBalance());
        System.out.println("Expected balance: ₹10000");
    }
}
