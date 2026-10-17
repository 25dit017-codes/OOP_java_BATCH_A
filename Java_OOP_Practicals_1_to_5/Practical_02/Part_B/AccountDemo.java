public class AccountDemo {
    public static void main(String[] args) {
        Account[] accounts = {
            new Account("Asha", 1000),
            new Account("Ravi"),
            new Account("Meera", 500)
        };

        accounts[0].deposit(250);
        accounts[1].deposit(700);
        accounts[2].withdraw(100);
        accounts[0].withdraw(200);
        System.out.println("Transfer Rs. 100 from first to second: "
                + accounts[0].transferTo(accounts[1], 100));

        for (Account account : accounts) {
            System.out.println(account.getAccountNumber() + " | "
                    + account.getOwnerName() + " | Balance: Rs. "
                    + account.getBalance());
        }
    }
}
