public class Account {
    @Id
    private String accountNumber;
    private String ownerName;
    private long balance;
    public Account(String accountNumber, String ownerName, long balance) {
        this.accountNumber = accountNumber; this.ownerName = ownerName; this.balance = balance;
    }
    public String toString() { return accountNumber + " | " + ownerName + " | ₹" + balance; }
}
