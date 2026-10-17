import java.util.Objects;

public class Account {
    private final String accountNumber;
    private String ownerName;
    private long balance;
    private boolean active;
    private static int nextAccountNumber = 1;

    public Account(String ownerName) { this(ownerName, 0); }

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

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public long getBalance() { return balance; }
    public boolean isActive() { return active; }

    @Override
    public String toString() {
        return "Account{accountNumber='" + accountNumber + "', ownerName='" + ownerName
                + "', balance=" + balance + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Account other)) return false;
        return accountNumber.equals(other.accountNumber);
    }

    @Override
    public int hashCode() { return Objects.hash(accountNumber); }
}
