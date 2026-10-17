package minibank.model;
public class Account {
    private final String accountNumber;
    private long balance;
    public Account(String accountNumber, long balance) { this.accountNumber = accountNumber; this.balance = balance; }
    public String getAccountNumber() { return accountNumber; }
    public synchronized long getBalance() { return balance; }
    public synchronized void deposit(long amount) throws InvalidAmountException {
        if (amount <= 0) throw new InvalidAmountException("Deposit amount must be positive.");
        balance += amount;
    }
    public synchronized void withdraw(long amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) throw new InvalidAmountException("Withdrawal amount must be positive.");
        if (amount > balance) throw new InsufficientFundsException(amount - balance);
        balance -= amount;
    }
    public void transfer(Account to, long amount) throws InvalidAmountException, InsufficientFundsException {
        if (to == null) throw new IllegalArgumentException("Destination account is missing.");
        synchronized (this) {
            if (amount <= 0) throw new InvalidAmountException("Transfer amount must be positive.");
            if (amount > balance) throw new InsufficientFundsException(amount - balance);
            balance -= amount;
        }
        try { to.deposit(amount); }
        catch (InvalidAmountException e) {
            try { deposit(amount); } catch (InvalidAmountException ignored) {}
            throw e;
        }
    }
    @Override public String toString() { return accountNumber + " balance=₹" + getBalance(); }
}
