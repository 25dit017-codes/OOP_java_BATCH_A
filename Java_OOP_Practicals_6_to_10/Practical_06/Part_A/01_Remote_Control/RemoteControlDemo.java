public class RemoteControlDemo {
    public static void main(String[] args) {
        Switchable fan = new Fan();
        fan.on(); fan.toggle(); fan.off();
        Switchable light = new Light();
        light.on(); light.off();
        Switchable alarm = new Switchable() {
            public void on() { System.out.println("Alarm is ON"); }
            public void off() { System.out.println("Alarm is OFF"); }
        };
        alarm.on(); alarm.off();
        Runnable command = () -> System.out.println("Lambda command executed");
        command.run();
    }
}
