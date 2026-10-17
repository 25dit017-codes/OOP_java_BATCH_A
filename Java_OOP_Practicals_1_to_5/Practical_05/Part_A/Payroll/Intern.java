public class Intern extends Employee {
    private final double stipend;
    public Intern(String name, double stipend) { super(name); this.stipend = stipend; }
    @Override public double monthlySalary() { return stipend; }
}
