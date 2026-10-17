public class StatementFormatter {
    public static String buildStatement(Account account) {
        StringBuilder sb = new StringBuilder();
        sb.append("MiniBank Statement\n");
        sb.append("------------------\n");
        sb.append("Account: ").append(account.getAccountNumber()).append('\n');
        sb.append("Owner: ").append(account.getOwnerName()).append('\n');
        sb.append("Balance: Rs. ").append(account.getBalance()).append('\n');
        return sb.toString();
    }

    public static void main(String[] args) {
        Account account = new Account("AC0001", "Asha", 1500);
        System.out.print(buildStatement(account));
    }
}
