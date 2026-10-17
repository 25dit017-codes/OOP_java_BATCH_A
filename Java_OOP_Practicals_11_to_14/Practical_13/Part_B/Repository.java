import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class Repository<T> {
    private final HashMap<String, T> items = new HashMap<>();
    public T save(T entity) {
        try {
            for (Field field : entity.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Id.class)) {
                    field.setAccessible(true);
                    Object value = field.get(entity);
                    if (value == null) throw new IllegalArgumentException("ID cannot be null");
                    items.put(value.toString(), entity);
                    return entity;
                }
            }
            throw new IllegalArgumentException("No @Id field found");
        } catch (IllegalAccessException e) { throw new RuntimeException(e); }
    }
    @SafeVarargs
    public final void saveAll(T... entities) { for (T entity : entities) save(entity); }
    public T findById(String id) { return items.get(id); }
    public ArrayList<T> findAll() { return new ArrayList<>(items.values()); }
    public boolean delete(String id) { return items.remove(id) != null; }
    public int size() { return items.size(); }
    public static <N extends Number> double average(N[] values) {
        if (values.length == 0) return 0;
        double sum = 0;
        for (N n : values) sum += n.doubleValue();
        return sum / values.length;
    }
}
