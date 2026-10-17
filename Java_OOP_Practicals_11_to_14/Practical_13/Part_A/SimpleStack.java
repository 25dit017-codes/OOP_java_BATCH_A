import java.util.ArrayList;

public class SimpleStack<T> {
    private final ArrayList<T> items = new ArrayList<>();
    public void push(T item) { items.add(item); }
    public T pop() {
        if (items.isEmpty()) return null;
        return items.remove(items.size() - 1);
    }
    public boolean isEmpty() { return items.isEmpty(); }
    public static void main(String[] args) {
        SimpleStack<String> names = new SimpleStack<>();
        names.push("Aman"); names.push("Riya");
        System.out.println(names.pop());
        System.out.println(names.pop());
        System.out.println(names.pop());
        SimpleStack<Integer> numbers = new SimpleStack<>();
        numbers.push(10); numbers.push(20);
        System.out.println(numbers.pop());
    }
}
