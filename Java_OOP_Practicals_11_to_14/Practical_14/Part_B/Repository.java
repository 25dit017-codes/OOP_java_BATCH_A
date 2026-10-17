import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class Repository<T> {
    private final HashMap<String, T> items = new HashMap<>();
    public synchronized T save(T entity) {
        try {
            for (Field field : entity.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Id.class)) {
                    field.setAccessible(true);
                    Object id = field.get(entity);
                    if (id == null) throw new IllegalArgumentException("ID cannot be null");
                    items.put(id.toString(), entity);
                    return entity;
                }
            }
            throw new IllegalArgumentException("Missing @Id field");
        } catch (IllegalAccessException e) { throw new RuntimeException(e); }
    }
    public synchronized T findById(String id) { return items.get(id); }
    public synchronized ArrayList<T> findAll() { return new ArrayList<>(items.values()); }
    public synchronized boolean delete(String id) { return items.remove(id) != null; }
}
