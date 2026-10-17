public class ResourceManagementDemo {
    public static void main(String[] args) {
        try (DemoResource resource = new DemoResource()) { resource.use(); }
    }
}
