import java.util.Scanner;

public class PasswordChecker {
    static String strength(String password) {
        int rules = 0;
        if (password.length() >= 8) rules++;
        if (password.matches(".*[A-Z].*")) rules++;
        if (password.matches(".*\\d.*")) rules++;
        if (password.matches(".*[^a-zA-Z0-9].*")) rules++;
        if (rules <= 1) return "Weak";
        if (rules <= 3) return "Medium";
        return "Strong";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        System.out.println("Password strength: " + strength(password));
        sc.close();
    }
}
