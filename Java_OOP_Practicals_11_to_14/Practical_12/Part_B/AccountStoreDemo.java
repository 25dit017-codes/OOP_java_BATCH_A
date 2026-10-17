public class AccountStoreDemo {
    public static void main(String[] args) {
        AccountStore store = new AccountStore();
        store.add(new Account("AC0001", "Aman", 5000));
        store.add(new Account("AC0002", "Riya", 2000));
        store.add(new Account("AC0003", "Dev", 9000));
        System.out.println("Lookup AC0002: " + store.get("AC0002"));
        System.out.println("Sorted by balance:");
        for (Account a : store.sortedByBalance()) System.out.println(a);
        TransactionProcessor processor = new TransactionProcessor();
        for (Account a : store.getAll()) processor.add(a);
        processor.deposit("AC0001", 500);
        System.out.println("Thread-safe store size: " + processor.size());
        System.out.println("History: " + store.getHistory());
    }
}
