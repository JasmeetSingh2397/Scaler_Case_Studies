package Services;

import Repositories.ParkingLotRepository;
import Strategies.SpotAssignmentStrategy;
import models.Gate;
import models.ParkingLot;
import models.ParkingSpot;
import models.Vehicle;

import java.util.List;

public class ParkingLotService {
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;

    private ParkingLot parkingLot;//Need to clarify this. Who will put the parking Lot id
    // to fetch the parking lot from the parking Spot Repository.

    public ParkingLotService(SpotAssignmentStrategy spotAssignmentStrategy, ParkingLotRepository parkingLotRepository) {
        this.spotAssignmentStrategy = spotAssignmentStrategy;//Ask how are we creating an object of an interface here.
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLotService(SpotAssignmentStrategy spotAssignmentStrategy) {
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }

    public ParkingLotService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingSpot getParkingSpot(Vehicle vehicle, Gate gate ){
        List<ParkingSpot> parkingSpots= parkingLotRepository.getAllParkingSpots(parkingLot.getId());
        return spotAssignmentStrategy.assignSpot(vehicle.getVehicleType(), gate, parkingSpots);


    }
}
