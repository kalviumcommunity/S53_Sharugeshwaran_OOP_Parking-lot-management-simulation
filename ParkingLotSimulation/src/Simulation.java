import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Simulation {
    private final ParkingLot parkingLot;
    private final FeeCalculator feeCalculator;

    public Simulation() {
        this.parkingLot = new ParkingLot(5);  
        this.feeCalculator = new FeeCalculator();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Parking Lot Simulation Started!");

        while (true) {
            System.out.println("1. Park a vehicle");
            System.out.println("2. Vacate a space");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter vehicle type (car/motorcycle/truck):");
                String type = scanner.next();
                System.out.println("Enter license plate:");
                String licensePlate = scanner.next();

                Vehicle vehicle;
                if (type.equalsIgnoreCase("car")) {
                    vehicle = new Car(licensePlate);
                } else if (type.equalsIgnoreCase("motorcycle")) {
                    vehicle = new Motorcycle(licensePlate);
                } else if (type.equalsIgnoreCase("truck")) {
                    vehicle = new Truck(licensePlate);
                } else {
                    System.out.println("Invalid vehicle type.");
                    continue;
                }

                ParkingSpace space = parkingLot.findAvailableSpace();
                if (space != null) {
                    space.park(vehicle);
                    System.out.println("Vehicle parked in space " + space.getNumber());
                } else {
                    System.out.println("No available spaces.");
                }
            } else if (choice == 2) {
                System.out.println("Enter space number to vacate:");
                int spaceNumber = scanner.nextInt();
                ParkingSpace space = parkingLot.getSpace(spaceNumber);

                if (space != null && space.isOccupied()) {
                    System.out.println("Enter license plate of the vehicle to vacate:");
                    String licensePlate = scanner.next();

                    if (space.getLicensePlate().equals(licensePlate)) {
                        // Calculate the fee
                        Duration parkingDuration = Duration.between(space.getStartTime(), LocalDateTime.now());
                        long hoursParked = parkingDuration.toHours();
                        double fee = FeeCalculator.calculateFee(space.getVehicle(), (int) hoursParked);

                        // Vacate the space
                        parkingLot.vacateSpace(spaceNumber);

                        System.out.println("Space " + spaceNumber + " vacated.");
                        System.out.println("Total parking fee: $" + fee);
                    } else {
                        System.out.println("License plate does not match.");
                    }
                } else {
                    System.out.println("No vehicle found in space " + spaceNumber);
                }
            } else if (choice == 3) {
                break;
            }
        }

        scanner.close();
    }
}