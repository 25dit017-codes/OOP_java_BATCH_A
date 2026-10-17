import java.lang.reflect.Field;
public class ColumnMappingDemo {
    public static void main(String[] args) {
        for (Field field : StudentRow.class.getDeclaredFields())
            if (field.isAnnotationPresent(Column.class))
                System.out.println(field.getName() + " maps to column " +
                    field.getAnnotation(Column.class).value());
    }
}
