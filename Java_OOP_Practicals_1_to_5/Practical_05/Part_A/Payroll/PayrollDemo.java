public class PayrollDemo {
    public static void main(String[] args) {
        Employee[] employees = {
            new FullTime("Asha", 45000),
            new PartTime("Ravi", 60, 250),
            new Intern("Meera", 12000)
        };
        double total = 0;
        for (Employee employee : employees) {
            System.out.println(employee.name + " salary: Rs. " + employee.monthlySalary());
            total += employee.monthlySalary();
        }
        System.out.println("Total monthly payroll: Rs. " + total);
    }
}
