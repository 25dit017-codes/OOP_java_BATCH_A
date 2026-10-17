package minibank.service;
import minibank.model.Account;
public class MiniBankConcurrencyDemo {
    public static void main(String[] args) throws InterruptedException {
        Account a = new Account("AC1001", 1000), b = new Account("AC1002", 1000);
        TransactionProcessor processor = new TransactionProcessor();
        for (int i = 1; i <= 5; i++) {
            processor.submit(() -> a.deposit(100));
            processor.submit(() -> b.withdraw(50));
        }
        processor.stop();
        System.out.println("A balance after batch: ₹" + a.getBalance());
        System.out.println("B balance after batch: ₹" + b.getBalance());
        Thread one = new Thread(() -> { for (int i = 0; i < 100; i++) Account.transfer(a, b, 1); });
        Thread two = new Thread(() -> { for (int i = 0; i < 100; i++) Account.transfer(b, a, 1); });
        one.start(); two.start(); one.join(); two.join();
        System.out.println("After safe transfers: A=₹" + a.getBalance() + ", B=₹" + b.getBalance());
        TransactionBuffer buffer = new TransactionBuffer(3);
        Thread producer = new Thread(() -> {
            try { for (int i = 0; i < 3; i++) buffer.put(() -> System.out.println("Buffered transaction processed")); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        Thread consumer = new Thread(() -> {
            try { for (int i = 0; i < 3; i++) buffer.take().run(); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        producer.start(); consumer.start(); producer.join(); consumer.join();
    }
}
