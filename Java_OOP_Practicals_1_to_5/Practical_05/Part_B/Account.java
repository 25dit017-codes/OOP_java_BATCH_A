public abstract class Account {
    private final String accountNumber;
    protected String ownerName;
    protected long balance;
    protected boolean active;

    public Account(String accountNumber, String ownerName, long balance) {
        if (balance < 0) throw new IllegalArgumentException("Opening balance cannot be negative");
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.active = true;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public long getBalance() { return balance; }
    public boolean isActive() { return active; }

    public abstract double interestRate();
    public abstract boolean canWithdraw(long amount);

    public void applyMonthlyInterest() {
        if (active) {
            balance += Math.round(balance * interestRate() / 12.0);
        }
    }

    public boolean deposit(long amount) {
        if (!active || amount <= 0) return false;
        balance += amount;
        return true;
    }

    public boolean withdraw(long amount) {
        if (!active || amount <= 0 || !canWithdraw(amount)) return false;
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return accountNumber + " | " + ownerName + " | Balance: Rs. " + balance;
    }
}
