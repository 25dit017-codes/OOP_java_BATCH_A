public class SampleTests {
    @Run public void firstTest() { System.out.println("First test executed"); }
    public void ignoredMethod() { System.out.println("This should not run"); }
    @Run public void secondTest() { System.out.println("Second test executed"); }
}
