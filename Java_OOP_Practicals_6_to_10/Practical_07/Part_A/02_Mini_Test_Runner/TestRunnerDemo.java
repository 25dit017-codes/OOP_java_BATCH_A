import java.lang.reflect.Method;
public class TestRunnerDemo {
    public static void main(String[] args) throws Exception {
        SampleTests tests = new SampleTests();
        for (Method method : tests.getClass().getDeclaredMethods())
            if (method.isAnnotationPresent(Run.class)) method.invoke(tests);
    }
}
