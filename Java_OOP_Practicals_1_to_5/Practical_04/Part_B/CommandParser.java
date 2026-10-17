public class CommandParser {
    public static Command parse(String line) {
        if (line == null) throw new IllegalArgumentException("Command cannot be null");
        String[] parts = line.trim().split("\\s+");
        if (parts.length != 3) throw new IllegalArgumentException("Expected: TYPE ACCOUNT_NUMBER AMOUNT");

        TransactionType type;
        long amount;
        try {
            type = TransactionType.valueOf(parts[0].toUpperCase());
            amount = Long.parseLong(parts[2]);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Invalid transaction type or amount");
        }

        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (!parts[1].matches("AC\\d{4}")) throw new IllegalArgumentException("Invalid account number");
        return new Command(type, parts[1], amount);
    }

    public static void main(String[] args) {
        String[] tests = {"DEPOSIT AC0001 500", "WITHDRAW AC0002 200", "DEPOSIT wrong 10"};
        for (String line : tests) {
            try {
                Command command = parse(line);
                System.out.println(command.type() + " | " + command.accountNumber() + " | " + command.amount());
            } catch (IllegalArgumentException e) {
                System.out.println("Rejected: " + line + " (" + e.getMessage() + ")");
            }
        }
        System.out.println("Valid mobile: " + Validator.isValidMobile("9876543210"));
        System.out.println("Valid email: " + Validator.isValidEmail("student@example.com"));
        System.out.println("Valid PAN: " + Validator.isValidPan("ABCDE1234F"));
        System.out.println("Valid IFSC: " + Validator.isValidIfsc("ABCD0123456"));
    }
}
