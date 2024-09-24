import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final List<ParkingSpace> spaces;

    public ParkingLot(int numSpaces) {
        spaces = new ArrayList<>();
        for (int i = 1; i <= numSpaces; i++) {
            spaces.add(new ParkingSpace(i));
        }
    }

    public ParkingSpace findAvailableSpace() {
        for (ParkingSpace space : spaces) {
            if (!space.isOccupied()) {
                return space;
            }
        }
        return null;  // No available spaces
    }

    public ParkingSpace getSpace(int spaceNumber) {
        if (spaceNumber >= 1 && spaceNumber <= spaces.size()) {
            return spaces.get(spaceNumber - 1);
        }
        return null;  // Invalid space number
    }

    public void vacateSpace(int spaceNumber) {
        ParkingSpace space = getSpace(spaceNumber);
        if (space != null) {
            space.vacate();
        }
    }
}
