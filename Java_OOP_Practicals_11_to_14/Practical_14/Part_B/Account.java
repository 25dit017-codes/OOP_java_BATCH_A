import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private final String accountNumber;
    private final String ownerName;
    private long balance;
    public Account(String accountNumber, String ownerName, long balance) {
        this.accountNumber = accountNumber; this.ownerName = ownerName; this.balance = balance;
    }
    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public synchronized long getBalance() { return balance; }
    public synchronized void deposit(long amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        balance += amount;
    }
    public synchronized void withdraw(long amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance");
        balance -= amount;
    }
    public String toString() { return accountNumber + " | " + ownerName + " | ₹" + getBalance(); }
}
