public class DemoResource implements AutoCloseable {
    public DemoResource() { System.out.println("Resource opened"); }
    public void use() { System.out.println("Resource is being used"); }
    @Override public void close() { System.out.println("Resource closed"); }
}
