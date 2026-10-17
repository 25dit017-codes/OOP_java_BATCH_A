package minibank.service;
import minibank.model.Account;
import minibank.model.PremiumAccount;
import minibank.util.WithdrawRule;
import static minibank.util.BankMessages.welcome;
public class MiniBankDemo {
    public static void main(String[] args) {
        welcome();
        Account account = new Account("AC1001", 1000);
        WithdrawRule anonymous = new WithdrawRule() {
            public boolean allow(Account a, long amount) {
                return amount > 0 && amount <= a.getBalance();
            }
        };
        WithdrawRule lambda = (a, amount) -> amount > 0 && amount <= a.getBalance() && amount <= 500;
        System.out.println("Anonymous allows ₹700: " + anonymous.allow(account, 700));
        System.out.println("Lambda allows ₹700: " + lambda.allow(account, 700));
        account.deposit(200); account.withdraw(100);
        System.out.println(account);
        System.out.println("Yearly interest: ₹" + account.yearlyInterest(account.getBalance()));
        Account premium = new PremiumAccount("AC1002", 500);
        System.out.println("Premium marker: " + (premium instanceof minibank.model.Premium));
    }
}
