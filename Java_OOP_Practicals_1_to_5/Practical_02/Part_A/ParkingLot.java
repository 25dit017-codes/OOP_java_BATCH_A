public class ParkingLot {
    private final int twoWheelerCapacity;
    private final int fourWheelerCapacity;
    private int twoWheelerOccupancy;
    private int fourWheelerOccupancy;

    public ParkingLot(int twoWheelerCapacity, int fourWheelerCapacity) {
        if (twoWheelerCapacity < 0 || fourWheelerCapacity < 0)
            throw new IllegalArgumentException("Capacity cannot be negative");
        this.twoWheelerCapacity = twoWheelerCapacity;
        this.fourWheelerCapacity = fourWheelerCapacity;
    }

    public boolean parkTwoWheeler() {
        if (twoWheelerOccupancy >= twoWheelerCapacity) return false;
        twoWheelerOccupancy++;
        return true;
    }

    public boolean parkFourWheeler() {
        if (fourWheelerOccupancy >= fourWheelerCapacity) return false;
        fourWheelerOccupancy++;
        return true;
    }

    public boolean removeTwoWheeler() {
        if (twoWheelerOccupancy == 0) return false;
        twoWheelerOccupancy--;
        return true;
    }

    public boolean removeFourWheeler() {
        if (fourWheelerOccupancy == 0) return false;
        fourWheelerOccupancy--;
        return true;
    }

    public int getTwoWheelerOccupancy() { return twoWheelerOccupancy; }
    public int getFourWheelerOccupancy() { return fourWheelerOccupancy; }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(2, 1);
        int toll = 0;
        if (lot.parkTwoWheeler()) toll += 20;
        if (lot.parkTwoWheeler()) toll += 20;
        System.out.println("Third two-wheeler accepted: " + lot.parkTwoWheeler());
        if (lot.parkFourWheeler()) toll += 40;
        System.out.println("Second four-wheeler accepted: " + lot.parkFourWheeler());
        System.out.println("Occupancy: " + lot.getTwoWheelerOccupancy() + " two-wheelers, "
                + lot.getFourWheelerOccupancy() + " four-wheelers");
        System.out.println("Parking charges collected: Rs. " + toll);
    }
}
