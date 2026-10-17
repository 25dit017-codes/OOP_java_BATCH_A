public class SavingsAccount extends Account {
    private static final long MINIMUM_BALANCE = 1000;

    public SavingsAccount(String accountNumber, String ownerName, long balance) {
        super(accountNumber, ownerName, balance);
    }

    @Override public double interestRate() { return 0.04; }

    @Override
    public boolean canWithdraw(long amount) {
        return amount > 0 && balance - amount >= MINIMUM_BALANCE;
    }
}
