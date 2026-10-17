import java.util.Scanner;

public class ChatLogFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder report = new StringBuilder();
        System.out.print("Enter keyword to search: ");
        String keyword = sc.nextLine();
        System.out.println("Enter log lines; type END to finish:");

        while (true) {
            String line = sc.nextLine();
            if (line.equals("END")) break;
            String[] parts = line.split(" ", 3);
            if (parts.length < 3 || parts[0].isBlank() || parts[1].isBlank()) {
                continue;
            }
            if (line.toLowerCase().contains(keyword.toLowerCase())) {
                report.append(line).append(System.lineSeparator());
            }
        }

        System.out.println("--- Matching log lines ---");
        System.out.print(report.length() == 0 ? "No matches found.\n" : report.toString());
        sc.close();
    }
}
