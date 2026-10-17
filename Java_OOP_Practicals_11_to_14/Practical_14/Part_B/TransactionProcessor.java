import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionProcessor {
    private final ConcurrentHashMap<String, Account> accounts = new ConcurrentHashMap<>();
    public void addAll(List<Account> list) { for (Account a : list) accounts.put(a.getAccountNumber(), a); }
    public void deposit(String number, long amount) {
        Account account = accounts.get(number);
        if (account == null) throw new IllegalArgumentException("Account not found");
        account.deposit(amount);
    }
    public void processDemoBatch() {
        Thread[] workers = new Thread[5];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Thread(() -> deposit("AC0001", 100));
            workers[i].start();
        }
        for (Thread worker : workers) {
            try { worker.join(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    }
}
