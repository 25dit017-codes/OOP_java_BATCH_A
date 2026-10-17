import java.util.Scanner;

public class MiniBank {
    record BankInfo(String name, String branch) { }
    enum MenuOption { OPEN_ACCOUNT, DEPOSIT, WITHDRAW, TRANSFER, EXIT, HOURS }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankInfo bank = new BankInfo("MiniBank", "Vadodara");
        boolean running = true;
        System.out.println("Welcome to " + bank.name());
        System.out.println("Branch: " + bank.branch());

        while (running) {
            System.out.println("\n===== MiniBank Menu =====");
            System.out.println("1. Open Account\n2. Deposit\n3. Withdraw\n4. Transfer");
            System.out.println("5. Exit\n6. Bank Working Hours");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Enter a number.");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();
            MenuOption option = switch (choice) {
                case 1 -> MenuOption.OPEN_ACCOUNT;
                case 2 -> MenuOption.DEPOSIT;
                case 3 -> MenuOption.WITHDRAW;
                case 4 -> MenuOption.TRANSFER;
                case 5 -> MenuOption.EXIT;
                case 6 -> MenuOption.HOURS;
                default -> null;
            };

            if (option == null) {
                System.out.println("Invalid menu choice. Try again.");
                continue;
            }

            switch (option) {
                case OPEN_ACCOUNT -> System.out.println("Open Account selected.");
                case DEPOSIT -> System.out.println("Deposit selected.");
                case WITHDRAW -> System.out.println("Withdraw selected.");
                case TRANSFER -> System.out.println("Transfer selected.");
                case HOURS -> System.out.println("Working hours: Monday to Friday, 9 AM to 5 PM.");
                case EXIT -> {
                    System.out.println("Thank you for using MiniBank.");
                    System.out.println("Goodbye!");
                    running = false;
                }
            }
        }
        sc.close();
    }
}
