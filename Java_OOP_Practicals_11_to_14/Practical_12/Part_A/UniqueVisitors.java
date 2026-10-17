import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {
        List<String> logins = Arrays.asList("aman", "riya", "dev", "aman", "neha", "riya", "jay");
        Set<String> unique = new HashSet<>(logins);
        Set<String> order = new LinkedHashSet<>(logins);
        System.out.println("Unique users: " + unique.size());
        System.out.println("First three distinct users:");
        int shown = 0;
        for (String name : order) {
            if (shown == 3) break;
            System.out.println(name);
            shown++;
        }
    }
}
