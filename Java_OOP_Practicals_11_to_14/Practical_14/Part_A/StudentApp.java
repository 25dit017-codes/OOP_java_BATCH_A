import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add student  2. Show count  3. Exit");
            String choice = sc.nextLine();
            try {
                if (choice.equals("1")) {
                    System.out.print("Name: "); service.add(sc.nextLine());
                    System.out.println("Student added");
                } else if (choice.equals("2")) System.out.println("Count: " + service.count());
                else if (choice.equals("3")) break;
                else System.out.println("Invalid choice");
            } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        }
        sc.close();
    }
}
