import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateFiller {
    static String fill(String template, String[] keys, String[] values) {
        Pattern pattern = Pattern.compile("\\{(\\w+)\\}");
        Matcher matcher = pattern.matcher(template);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String key = matcher.group(1);
            String replacement = "[?]";
            for (int i = 0; i < keys.length; i++) {
                if (keys[i].equals(key)) {
                    replacement = values[i];
                    break;
                }
            }
            matcher.appendReplacement(result, Matcher.quoteReplacement(replacement));
        }
        matcher.appendTail(result);
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter template: ");
        String template = sc.nextLine();
        String[] keys = {"name", "id"};
        String[] values = new String[2];
        System.out.print("Enter name: ");
        values[0] = sc.nextLine();
        System.out.print("Enter id: ");
        values[1] = sc.nextLine();
        System.out.println(fill(template, keys, values));
        sc.close();
    }
}
