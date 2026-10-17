import java.util.ArrayList;

public class BankService {
    private final Repository<Account> accounts = new Repository<>();
    public Account openAccount(String number, String owner, long openingBalance) {
        if (number == null || number.isBlank() || owner == null || owner.isBlank())
            throw new IllegalArgumentException("Account number and owner are required");
        if (accounts.findById(number) != null) throw new IllegalArgumentException("Account already exists");
        if (openingBalance < 0) throw new IllegalArgumentException("Opening balance cannot be negative");
        Account account = new Account(number, owner, openingBalance);
        accounts.save(account);
        return account;
    }
    public void deposit(String number, long amount) { getAccount(number).deposit(amount); }
    public void withdraw(String number, long amount) { getAccount(number).withdraw(amount); }
    public void transfer(String from, String to, long amount) {
        if (from.equals(to)) throw new IllegalArgumentException("Choose two different accounts");
        Account a = getAccount(from), b = getAccount(to);
        synchronized (a) {
            synchronized (b) {
                a.withdraw(amount);
                b.deposit(amount);
            }
        }
    }
    public Account statement(String number) { return getAccount(number); }
    public ArrayList<Account> listAccounts() { return accounts.findAll(); }
    private Account getAccount(String number) {
        Account account = accounts.findById(number);
        if (account == null) throw new IllegalArgumentException("Account not found");
        return account;
    }
    public void load(Account[] saved) { for (Account a : saved) accounts.save(a); }
}
