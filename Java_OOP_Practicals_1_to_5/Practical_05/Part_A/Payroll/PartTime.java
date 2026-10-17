public class PartTime extends Employee {
    private final int hours;
    private final double rate;
    public PartTime(String name, int hours, double rate) {
        super(name); this.hours = hours; this.rate = rate;
    }
    @Override public double monthlySalary() { return hours * rate; }
}
