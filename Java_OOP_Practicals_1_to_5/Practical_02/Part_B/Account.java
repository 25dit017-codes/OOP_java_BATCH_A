public class Account {
    private final String accountNumber;
    private String ownerName;
    private long balance;
    private boolean active;
    private static int nextAccountNumber = 1;

    public Account(String ownerName) {
        this(ownerName, 0);
    }

    public Account(String ownerName, long openingBalance) {
        if (openingBalance < 0) throw new IllegalArgumentException("Opening balance cannot be negative");
        this.accountNumber = String.format("AC%04d", nextAccountNumber++);
        this.ownerName = ownerName;
        this.balance = openingBalance;
        this.active = true;
    }

    public boolean deposit(long amount) {
        if (!active || amount <= 0) return false;
        balance += amount;
        return true;
    }

    public boolean withdraw(long amount) {
        if (!active || amount <= 0 || amount > balance) return false;
        balance -= amount;
        return true;
    }

    public boolean transferTo(Account destination, long amount) {
        if (destination == null || destination == this || amount <= 0
                || !active || !destination.active || amount > balance) {
            return false;
        }
        balance -= amount;
        destination.balance += amount;
        return true;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public long getBalance() { return balance; }
    public boolean isActive() { return active; }
}
