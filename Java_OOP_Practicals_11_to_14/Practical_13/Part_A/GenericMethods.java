public class GenericMethods {
    public static <T> T first(T[] values) {
        if (values == null || values.length == 0) return null;
        return values[0];
    }
    public static void main(String[] args) {
        Box<String> textBox = new Box<>("Hello Java");
        Box<Integer> numberBox = new Box<>(25);
        Pair<String, Integer> student = new Pair<>("Aman", 12);
        String[] names = {"Aman", "Riya"};
        System.out.println(textBox.get());
        System.out.println(numberBox.get());
        System.out.println(student);
        System.out.println("First name: " + first(names));
    }
}
