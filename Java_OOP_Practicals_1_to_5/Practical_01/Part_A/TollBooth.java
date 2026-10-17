import java.util.Scanner;

public class TollBooth {
    record Vehicle(String number, String type) { }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalToll = 0, bikes = 0, cars = 0, trucks = 0;

        while (true) {
            System.out.print("Enter vehicle number (or done): ");
            String number = sc.next();
            if (number.equalsIgnoreCase("done")) break;

            System.out.print("Enter type (bike/car/truck): ");
            String type = sc.next().toLowerCase();
            Vehicle vehicle = new Vehicle(number, type);

            int toll = switch (vehicle.type()) {
                case "bike" -> 20;
                case "car" -> 50;
                case "truck" -> 150;
                default -> -1;
            };

            if (toll == -1) {
                System.out.println("Invalid vehicle type.");
                continue;
            }

            totalToll += toll;
            switch (vehicle.type()) {
                case "bike" -> bikes++;
                case "car" -> cars++;
                case "truck" -> trucks++;
            }
            System.out.println("Vehicle: " + vehicle.number());
            System.out.println("Toll: Rs. " + toll);
        }

        System.out.println("\nTotal toll collected: Rs. " + totalToll);
        if (bikes == 0 && cars == 0 && trucks == 0) {
            System.out.println("No valid vehicles entered.");
        } else {
            int maximum = Math.max(bikes, Math.max(cars, trucks));
            System.out.print("Most frequent vehicle type: ");
            if (bikes == maximum) System.out.print("Bike ");
            if (cars == maximum) System.out.print("Car ");
            if (trucks == maximum) System.out.print("Truck ");
            System.out.println();
        }
        sc.close();
    }
}
