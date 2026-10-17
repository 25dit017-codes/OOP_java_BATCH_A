package minibank.model;
import minibank.model.annotation.Id;
import minibank.model.annotation.Positive;
import minibank.model.annotation.MaxLength;
public class Account {
    @Id @MaxLength(12) private String accountNumber;
    @Positive private long balance;
    public Account(String accountNumber, long balance) {
        this.accountNumber = accountNumber; this.balance = balance;
    }
    public long getBalance() { return balance; }
    @Override public String toString() { return accountNumber + " balance=₹" + balance; }
}
