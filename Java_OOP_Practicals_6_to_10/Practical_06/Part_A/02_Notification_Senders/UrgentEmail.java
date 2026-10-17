public class UrgentEmail implements Urgent {
    private String message;
    public UrgentEmail(String message) { this.message = message; }
    public void display() { System.out.println("URGENT EMAIL: " + message); }
}
