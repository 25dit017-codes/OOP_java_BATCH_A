public class CurrentAccount extends Account {
    private final long overdraftLimit;

    public CurrentAccount(String accountNumber, String ownerName, long balance, long overdraftLimit) {
        super(accountNumber, ownerName, balance);
        if (overdraftLimit < 0) throw new IllegalArgumentException("Overdraft limit cannot be negative");
        this.overdraftLimit = overdraftLimit;
    }

    @Override public double interestRate() { return 0.0; }

    @Override
    public boolean canWithdraw(long amount) {
        return amount > 0 && balance - amount >= -overdraftLimit;
    }
}
