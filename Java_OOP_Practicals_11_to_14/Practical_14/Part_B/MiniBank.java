import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class MiniBank {
    public static void main(String[] args) throws Exception {
        Path file = Path.of("data", "accounts.dat");
        BankService bank = new BankService();
        bank.load(StatePersister.load(file));
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nMINIBANK");
            System.out.println("1. Open account  2. Deposit  3. Withdraw  4. Transfer  5. List accounts  6. Save and exit");
            System.out.print("Choice: ");
            String choice = sc.nextLine();
            try {
                if (choice.equals("1")) {
                    System.out.print("Account number: "); String number = sc.nextLine();
                    System.out.print("Owner name: "); String owner = sc.nextLine();
                    System.out.print("Opening balance: "); long amount = Long.parseLong(sc.nextLine());
                    System.out.println(bank.openAccount(number, owner, amount));
                } else if (choice.equals("2")) {
                    System.out.print("Account number: "); String number = sc.nextLine();
                    System.out.print("Amount: "); bank.deposit(number, Long.parseLong(sc.nextLine()));
                    System.out.println("Deposit successful");
                } else if (choice.equals("3")) {
                    System.out.print("Account number: "); String number = sc.nextLine();
                    System.out.print("Amount: "); bank.withdraw(number, Long.parseLong(sc.nextLine()));
                    System.out.println("Withdrawal successful");
                } else if (choice.equals("4")) {
                    System.out.print("From account: "); String from = sc.nextLine();
                    System.out.print("To account: "); String to = sc.nextLine();
                    System.out.print("Amount: "); bank.transfer(from, to, Long.parseLong(sc.nextLine()));
                    System.out.println("Transfer successful");
                } else if (choice.equals("5")) {
                    for (Account a : bank.listAccounts()) System.out.println(a);
                } else if (choice.equals("6")) {
                    StatePersister.save(bank.listAccounts(), file);
                    System.out.println("Accounts saved. Goodbye!");
                    break;
                } else System.out.println("Invalid choice");
            } catch (RuntimeException e) { System.out.println("Error: " + e.getMessage()); }
        }
        sc.close();
    }
}
