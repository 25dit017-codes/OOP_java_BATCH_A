package minibank.service;
import minibank.model.*;
public class MiniBankExceptionDemo {
    public static void main(String[] args) {
        Account a = new Account("AC1001", 500);
        Account b = new Account("AC1002", 100);
        try (BankResource resource = new BankResource()) {
            resource.work();
            a.withdraw(800);
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        } catch (BankException e) {
            System.out.println("Bank error: " + e.getMessage());
        } finally { System.out.println("Transaction attempt finished."); }
        try {
            a.transfer(b, 100);
            System.out.println(a); System.out.println(b);
        } catch (BankException e) { System.out.println("Transfer failed: " + e.getMessage()); }
    }
}
