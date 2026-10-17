public class NotificationDemo {
    public static void main(String[] args) {
        Notifier email = message -> System.out.println("Email sent: " + message);
        Notifier sms = message -> System.out.println("SMS sent: " + message);
        email.send("Practical submission reminder");
        sms.send("Class starts at 10 AM");
        UrgentEmail urgent = new UrgentEmail("Exam schedule changed");
        urgent.display();
        System.out.println("Urgent marker present: " + (urgent instanceof Urgent));
    }
}
