public class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public double getParkingRate() {
        return 3.0;
    }
}
