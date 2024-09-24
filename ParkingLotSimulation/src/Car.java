public class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public double getParkingRate() {
        return 5.0;
    }
}
