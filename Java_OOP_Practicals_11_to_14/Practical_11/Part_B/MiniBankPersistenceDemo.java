import java.nio.file.*;

public class MiniBankPersistenceDemo {
    public static void main(String[] args) throws Exception {
        Path data = Path.of("data");
        Path accountFile = data.resolve("accounts.dat");
        Path logs = data.resolve("logs");
        Account[] accounts = {
            new Account("AC0001", "Aman", 5000),
            new Account("AC0002", "Riya", 3000),
            new Account("AC0003", "Dev", 9000)
        };
        StatePersister.save(accounts, accountFile);
        TransactionLog.append(logs.resolve("transactions.log"), "DEPOSIT AC0001 500");
        TransactionLog.append(logs.resolve("transactions.log"), "WITHDRAW AC0002 200");
        Account[] loaded = StatePersister.load(accountFile);
        System.out.println("Loaded accounts:");
        for (Account a : loaded) System.out.println(a);
        System.out.println(ReportGenerator.generate(logs, data.resolve("report.txt")));
    }
}
