    public class Thermostat {
        private String location;
        private int temperature;
        private static int activeCount = 0;
        public static final int MIN = 16;
        public static final int MAX = 30;

        public Thermostat(String location) {
            this(location, 22);
        }

        public Thermostat(String location, int temperature) {
            if (temperature < MIN || temperature > MAX) {
                throw new IllegalArgumentException("Temperature must be between " + MIN + " and " + MAX);
            }
            this.location = location;
            this.temperature = temperature;
            activeCount++;
        }

        public void raise() {
            if (temperature < MAX) temperature++;
        }

        public void lower() {
            if (temperature > MIN) temperature--;
        }

        public String getLocation() { return location; }
        public int getTemperature() { return temperature; }
        public static int getActiveCount() { return activeCount; }

        public static void main(String[] args) {
            Thermostat t1 = new Thermostat("Living Room");
            Thermostat t2 = new Thermostat("Bedroom", 25);
            t1.raise();
            t2.lower();
            System.out.println(t1.getLocation() + ": " + t1.getTemperature());
            System.out.println(t2.getLocation() + ": " + t2.getTemperature());
            System.out.println("Active thermostats: " + getActiveCount());
        }
    }
