import java.util.*;

public class AccountStore {
    private final HashMap<String, Account> accounts = new HashMap<>();
    private final ArrayList<String> history = new ArrayList<>();
    public void add(Account account) {
        accounts.put(account.getAccountNumber(), account);
        history.add("Added " + account.getAccountNumber());
    }
    public Account get(String accountNumber) { return accounts.get(accountNumber); }
    public ArrayList<Account> getAll() { return new ArrayList<>(accounts.values()); }
    public ArrayList<String> getHistory() { return new ArrayList<>(history); }
    public ArrayList<Account> sortedByBalance() {
        ArrayList<Account> list = getAll();
        list.sort(Comparator.comparingLong(Account::getBalance).reversed());
        return list;
    }
    public ArrayList<Account> aboveBalance(long amount) {
        ArrayList<Account> list = new ArrayList<>();
        for (Account a : accounts.values()) if (a.getBalance() > amount) list.add(a);
        return list;
    }
}
