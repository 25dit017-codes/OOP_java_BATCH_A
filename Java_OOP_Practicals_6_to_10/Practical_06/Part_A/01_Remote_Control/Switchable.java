public interface Switchable {
    void on();
    void off();
    default void toggle() { System.out.println("Toggle requested"); }
}
