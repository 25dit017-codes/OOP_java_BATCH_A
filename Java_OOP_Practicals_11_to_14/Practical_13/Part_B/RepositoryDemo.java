public class RepositoryDemo {
    public static void main(String[] args) {
        Repository<Account> accounts = new Repository<>();
        accounts.saveAll(new Account("AC0001", "Aman", 5000),
                         new Account("AC0002", "Riya", 2000),
                         new Account("AC0003", "Dev", 9000));
        System.out.println("Find AC0002: " + accounts.findById("AC0002"));
        for (Account a : accounts.findAll()) System.out.println(a);
        System.out.println("Count: " + accounts.size());
        Repository<Customer> customers = new Repository<>();
        customers.save(new Customer("C001", "Neha"));
        System.out.println(customers.findById("C001"));
        Integer[] marks = {70, 80, 90};
        System.out.println("Average: " + Repository.average(marks));
    }
}
