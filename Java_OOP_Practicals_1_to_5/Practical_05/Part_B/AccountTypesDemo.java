public class AccountTypesDemo {
    public static void main(String[] args) {
        Account[] accounts = {
            new SavingsAccount("AC0001", "Asha", 5000),
            new CurrentAccount("AC0002", "Ravi", 1000, 2000),
            new FixedDepositAccount("AC0003", "Meera", 10000, 3)
        };

        for (Account account : accounts) {
            System.out.println(account);
            System.out.println("Interest rate: " + (account.interestRate() * 100) + "%");
            System.out.println("Can withdraw Rs. 1500: " + account.canWithdraw(1500));
            if (account instanceof SavingsAccount savings) {
                System.out.println("Savings account minimum balance rule applies.");
            }
            account.applyMonthlyInterest();
            System.out.println("After one month interest: " + account.getBalance());
            if (account instanceof FixedDepositAccount fd) {
                fd.elapseOneMonth();
                fd.elapseOneMonth();
                System.out.println("FD mature after 3 months? " + fd.isMature());
                fd.elapseOneMonth();
                System.out.println("FD mature after 3 months? " + fd.isMature());
                System.out.println("Withdraw after maturity: " + fd.withdraw(1000));
            }
            System.out.println();
        }
    }
}
