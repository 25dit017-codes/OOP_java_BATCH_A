package minibank.model;
public class Account {
    private long balance;
    public Account(long balance) { this.balance = balance; }
    public synchronized void deposit(long amount) { balance += amount; }
    public synchronized void withdraw(long amount) { if (amount > 0 && amount <= balance) balance -= amount; }
    public synchronized long getBalance() { return balance; }
}
