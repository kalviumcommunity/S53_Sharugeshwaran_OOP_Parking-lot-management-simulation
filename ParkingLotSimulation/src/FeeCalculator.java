public class FeeCalculator {
    public static double calculateFee(Vehicle vehicle, int hoursParked) {
        return vehicle.getParkingRate() * hoursParked;
    }
}
