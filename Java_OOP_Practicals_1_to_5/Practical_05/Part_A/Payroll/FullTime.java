public class FullTime extends Employee {
    private final double monthlyPay;
    public FullTime(String name, double monthlyPay) { super(name); this.monthlyPay = monthlyPay; }
    @Override public double monthlySalary() { return monthlyPay; }
}
