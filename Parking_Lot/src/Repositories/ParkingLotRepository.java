package Repositories;

import models.ParkingLot;
import models.ParkingSpot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {
    private Map<Long,List<ParkingSpot>> map;

    public ParkingLotRepository() {
        this.map = new HashMap<>();
    }

    public List<ParkingSpot> getAllParkingSpots(Long ParkingLotId) {
        return map.get(ParkingLotId);
    }

    public ParkingLot addNewParkingLot(ParkingLot parkingLot){
        map.put(parkingLot.getId(),new ArrayList<>());
        return parkingLot;
    }

    public ParkingSpot addNewParkingSpot(ParkingSpot parkingSpot,ParkingLot parkingLot){
        map.get(parkingLot.getId()).add(parkingSpot);
        return parkingSpot;
    }
}
