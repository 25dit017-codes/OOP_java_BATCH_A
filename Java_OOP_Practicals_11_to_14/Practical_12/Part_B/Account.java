import java.io.Serializable;

public class Account implements Comparable<Account>, Serializable {
    private static final long serialVersionUID = 1L;
    private final String accountNumber;
    private final String ownerName;
    private long balance;
    public Account(String accountNumber, String ownerName, long balance) {
        this.accountNumber = accountNumber; this.ownerName = ownerName; this.balance = balance;
    }
    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public long getBalance() { return balance; }
    public synchronized void deposit(long amount) { if (amount > 0) balance += amount; }
    public int compareTo(Account other) { return accountNumber.compareTo(other.accountNumber); }
    public String toString() { return accountNumber + " | " + ownerName + " | ₹" + balance; }
}
