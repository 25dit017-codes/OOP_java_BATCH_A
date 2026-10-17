package minibank.service;
public class BankResource implements AutoCloseable {
    public BankResource() { System.out.println("Bank resource opened"); }
    public void work() { System.out.println("Bank resource in use"); }
    @Override public void close() { System.out.println("Bank resource closed"); }
}
