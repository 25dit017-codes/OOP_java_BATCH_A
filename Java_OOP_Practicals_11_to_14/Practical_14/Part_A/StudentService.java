import java.util.ArrayList;

public class StudentService {
    private final ArrayList<Student> students = new ArrayList<>();
    public void add(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be empty");
        students.add(new Student(name));
    }
    public int count() { return students.size(); }
    public ArrayList<Student> getAll() { return new ArrayList<>(students); }
}
