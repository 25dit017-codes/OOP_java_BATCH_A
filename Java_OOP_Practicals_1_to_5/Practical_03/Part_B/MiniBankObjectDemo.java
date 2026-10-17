public class MiniBankObjectDemo {
    public static void main(String[] args) {
        Customer.Address address = new Customer.Address("12 River Road", "Vadodara", "390001");
        Customer customer = new Customer("Asha", "asha@example.com", "9876543210", address);
        Customer copy = customer.clone();

        Account a1 = new Account("Asha", 1000);
        Account a2 = new Account("Asha", 1000);

        System.out.println(a1);
        System.out.println("Accounts equal: " + a1.equals(a2));
        System.out.println("a1 instanceof Account: " + (a1 instanceof Account));
        System.out.println("Customer: " + customer.getName());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("Cloned customer: " + copy.getName());
        System.out.println("Same customer object: " + (customer == copy));
    }
}
