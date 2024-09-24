public class FeeCalculator {
    public double calculateFee(Vehicle vehicle, int hoursParked) {
        return vehicle.getParkingRate() * hoursParked;
    }
}
