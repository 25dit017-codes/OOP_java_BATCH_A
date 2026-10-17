package minibank.util;
import java.lang.reflect.Field;
import java.util.ArrayList;
import minibank.model.annotation.Positive;
import minibank.model.annotation.MaxLength;
public class AnnotationValidator {
    public static String[] validate(Object obj) {
        ArrayList<String> errors = new ArrayList<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                if (field.isAnnotationPresent(Positive.class) && value instanceof Number) {
                    Positive rule = field.getAnnotation(Positive.class);
                    if (((Number)value).longValue() <= 0) errors.add(field.getName() + " " + rule.message());
                }
                if (field.isAnnotationPresent(MaxLength.class) && value != null) {
                    int max = field.getAnnotation(MaxLength.class).value();
                    if (value.toString().length() > max)
                        errors.add(field.getName() + " length must be at most " + max);
                }
            } catch (IllegalAccessException e) { errors.add("Could not validate " + field.getName()); }
        }
        return errors.toArray(new String[0]);
    }
}
