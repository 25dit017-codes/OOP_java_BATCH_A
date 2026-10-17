import java.lang.reflect.Field;
public class FormValidatorDemo {
    public static void main(String[] args) throws Exception {
        StudentForm form = new StudentForm(" ", "student-with-a-very-long-email-address@example.com");
        for (Field field : form.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(form);
            if (field.isAnnotationPresent(NotBlank.class) &&
                    (value == null || value.toString().trim().isEmpty()))
                System.out.println(field.getName() + " must not be blank");
            if (field.isAnnotationPresent(MaxLength.class) && value != null) {
                int max = field.getAnnotation(MaxLength.class).value();
                if (value.toString().length() > max)
                    System.out.println(field.getName() + " exceeds " + max + " characters");
            }
        }
    }
}
