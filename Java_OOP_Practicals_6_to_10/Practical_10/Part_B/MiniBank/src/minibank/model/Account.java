package minibank.model;
public class Account {
    private final String accountNumber; private long balance;
    public Account(String accountNumber, long balance) { this.accountNumber = accountNumber; this.balance = balance; }
    public String getAccountNumber() { return accountNumber; }
    public synchronized long getBalance() { return balance; }
    public synchronized void deposit(long amount) { if (amount > 0) balance += amount; }
    public synchronized boolean withdraw(long amount) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount; return true;
    }
    public static void transfer(Account from, Account to, long amount) {
        Account first = from.accountNumber.compareTo(to.accountNumber) <= 0 ? from : to;
        Account second = first == from ? to : from;
        synchronized (first) {
            synchronized (second) {
                if (amount > 0 && from.balance >= amount) {
                    from.balance -= amount; to.balance += amount;
                }
            }
        }
    }
}
