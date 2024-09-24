public abstract class Vehicle {
    private final String licensePlate;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public abstract double getParkingRate();  // Different vehicles have different parking rates
}
