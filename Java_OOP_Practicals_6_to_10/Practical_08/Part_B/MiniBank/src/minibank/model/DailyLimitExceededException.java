package minibank.model;
public class DailyLimitExceededException extends BankException {
    public DailyLimitExceededException(String message) { super(message); }
}
