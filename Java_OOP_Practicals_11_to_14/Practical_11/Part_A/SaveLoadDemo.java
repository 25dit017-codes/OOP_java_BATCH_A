import java.io.*;

public class SaveLoadDemo {
    static class Student implements Serializable {
        private static final long serialVersionUID = 1L;
        String name;
        int rollNo;
        transient String password;

        Student(String name, int rollNo, String password) {
            this.name = name;
            this.rollNo = rollNo;
            this.password = password;
        }
        public String toString() {
            return name + " | " + rollNo + " | password=" + password;
        }
    }

    public static void main(String[] args) {
        Student[] students = { new Student("Aman", 11, "abc123"), new Student("Riya", 12, "xyz789") };
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            out.writeObject(students);
        } catch (IOException e) { System.out.println(e.getMessage()); }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("students.dat"))) {
            Student[] loaded = (Student[]) in.readObject();
            for (Student s : loaded) System.out.println(s);
        } catch (IOException | ClassNotFoundException e) { System.out.println(e.getMessage()); }
    }
}
