import java.time.LocalDateTime;

public class ParkingSpace {
    private final int number;
    private  boolean occupied;
    private Vehicle vehicle;
    private LocalDateTime startTime;
    private static int totalVehiclesParked = 0;

    public ParkingSpace(int number) {
        this.number = number;
        this.occupied = false;
        this.vehicle = null;
        this.startTime = null;
    }

    public int getNumber() {
        return number;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.occupied = true;
        this.startTime = LocalDateTime.now(); 
        totalVehiclesParked++; // Record the start time when the vehicle is parked
    }

    public void vacate() {
        this.vehicle = null;
        this.occupied = false;
        this.startTime = null;  
        totalVehiclesParked--;// Reset start time
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getLicensePlate() {
        return vehicle != null ? vehicle.getLicensePlate() : null;
    }
}

