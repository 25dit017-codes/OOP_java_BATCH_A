import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {
    @Test
    void addingStudentIncreasesCount() {
        StudentService service = new StudentService();
        service.add("Aman");
        assertEquals(1, service.count());
    }
    @Test
    void invalidNameThrowsException() {
        StudentService service = new StudentService();
        assertThrows(IllegalArgumentException.class, () -> service.add(""));
    }
    @Test
    void addingTwoStudentsGivesCountTwo() {
        StudentService service = new StudentService();
        service.add("Aman"); service.add("Riya");
        assertEquals(2, service.count());
    }
}
