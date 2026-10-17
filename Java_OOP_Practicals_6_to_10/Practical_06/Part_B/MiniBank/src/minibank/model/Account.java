package minibank.model;
public class Account implements Transactable, InterestBearing {
    private final String accountNumber;
    private long balance;
    public Account(String accountNumber, long balance) {
        this.accountNumber = accountNumber; this.balance = balance;
    }
    public String getAccountNumber() { return accountNumber; }
    public long getBalance() { return balance; }
    @Override public void deposit(long amount) { if (amount > 0) balance += amount; }
    @Override public boolean withdraw(long amount) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount; return true;
    }
    @Override public String toString() { return accountNumber + " balance=₹" + balance; }
}
