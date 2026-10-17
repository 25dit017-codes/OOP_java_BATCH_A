public class FixedDepositAccount extends Account {
    private final int maturityMonths;
    private int monthsElapsed;

    public FixedDepositAccount(String accountNumber, String ownerName, long balance) {
        this(accountNumber, ownerName, balance, 12);
    }

    public FixedDepositAccount(String accountNumber, String ownerName, long balance,
                               int maturityMonths) {
        super(accountNumber, ownerName, balance);
        if (maturityMonths <= 0) {
            throw new IllegalArgumentException("Maturity must be at least one month");
        }
        this.maturityMonths = maturityMonths;
        this.monthsElapsed = 0;
    }

    @Override public double interestRate() { return 0.07; }

    @Override
    public boolean canWithdraw(long amount) {
        return amount > 0 && monthsElapsed >= maturityMonths && amount <= balance;
    }

    @Override
    public boolean withdraw(long amount) {
        if (!active || !canWithdraw(amount)) return false;
        balance -= amount;
        return true;
    }

    public void elapseOneMonth() {
        if (monthsElapsed < maturityMonths) {
            monthsElapsed++;
            applyMonthlyInterest();
        }
    }

    public boolean isMature() {
        return monthsElapsed >= maturityMonths;
    }

    public int getMonthsElapsed() { return monthsElapsed; }
    public int getMaturityMonths() { return maturityMonths; }
}
