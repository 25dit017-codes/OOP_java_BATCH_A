package minibank.service;
import minibank.model.Account;
public class AccountWorker implements Runnable {
    private Account account; private int iterations; private long amount;
    public AccountWorker(Account account, int iterations, long amount) {
        this.account = account; this.iterations = iterations; this.amount = amount;
    }
    @Override public void run() {
        for (int i = 0; i < iterations; i++) account.deposit(amount);
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
