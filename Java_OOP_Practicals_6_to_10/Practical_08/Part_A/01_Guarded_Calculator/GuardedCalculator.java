import java.util.Scanner;
public class GuardedCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter first number: ");
            double a = Double.parseDouble(sc.nextLine());
            System.out.print("Enter second number: ");
            double b = Double.parseDouble(sc.nextLine());
            System.out.print("Enter operator (+, -, *, /): ");
            String op = sc.nextLine();
            double result;
            switch (op) {
                case "+" -> result = a + b;
                case "-" -> result = a - b;
                case "*" -> result = a * b;
                case "/" -> {
                    if (b == 0) throw new ArithmeticException("Cannot divide by zero");
                    result = a / b;
                }
                default -> throw new IllegalArgumentException("Unknown operator");
            }
            System.out.println("Result: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numbers.");
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Calculation attempt completed.");
            sc.close();
        }
    }
}
