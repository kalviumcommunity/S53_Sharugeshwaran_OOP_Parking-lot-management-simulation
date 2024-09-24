public class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public double getParkingRate() {
        return 10.0;
    }
}
