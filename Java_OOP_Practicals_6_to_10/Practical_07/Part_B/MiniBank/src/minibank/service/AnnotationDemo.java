package minibank.service;
import minibank.model.Account;
import minibank.util.AnnotationValidator;
public class AnnotationDemo {
    public static void main(String[] args) {
        show("Invalid account", AnnotationValidator.validate(new Account("ACCOUNT-TOO-LONG-123", -50)));
        show("Valid account", AnnotationValidator.validate(new Account("AC1001", 500)));
    }
    private static void show(String title, String[] errors) {
        System.out.println(title + ":");
        if (errors.length == 0) System.out.println("No validation errors");
        for (String error : errors) System.out.println(error);
    }
}
