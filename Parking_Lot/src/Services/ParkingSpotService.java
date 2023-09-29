package Services;

import models.Gate;
import models.ParkingSpot;
import models.ParkingSpotStatus;
import models.Vehicle;

public class ParkingSpotService {




    public ParkingSpot assignParkingSpot(ParkingSpot parkingSpot){
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        return parkingSpot;
    }
}
