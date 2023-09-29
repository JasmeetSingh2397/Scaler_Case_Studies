package Strategies;

import models.Gate;
import models.ParkingSpot;
import models.VehicleType;

import java.util.List;

public interface SpotAssignmentStrategy {
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate, List<ParkingSpot> parkingSpotList);
}
