public class Account {
    private final String accountNumber;
    private final String ownerName;
    private long balance;

    public Account(String accountNumber, String ownerName, long balance) {
        if (balance < 0) throw new IllegalArgumentException("Balance cannot be negative");
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public long getBalance() { return balance; }
    public boolean deposit(long amount) {
        if (amount <= 0) return false;
        balance += amount;
        return true;
    }
    public boolean withdraw(long amount) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount;
        return true;
    }
}
