public class MiniBankTest {
    public static void main(String[] args) {
        BankService bank = new BankService();
        bank.openAccount("AC0001", "Aman", 1000);
        bank.openAccount("AC0002", "Riya", 500);
        bank.deposit("AC0001", 200);
        if (bank.statement("AC0001").getBalance() != 1200) throw new AssertionError("Deposit test failed");
        boolean failed = false;
        try { bank.withdraw("AC0002", 1000); } catch (IllegalArgumentException e) { failed = true; }
        if (!failed) throw new AssertionError("Insufficient balance test failed");
        bank.transfer("AC0001", "AC0002", 200);
        if (bank.statement("AC0001").getBalance() != 1000 || bank.statement("AC0002").getBalance() != 700)
            throw new AssertionError("Transfer test failed");
        System.out.println("All MiniBank tests passed");
    }
}
