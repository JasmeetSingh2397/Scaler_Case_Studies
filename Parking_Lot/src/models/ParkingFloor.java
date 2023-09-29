package models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ParkingFloor extends BaseEntity{
    private List<ParkingSpot> parkingSpots;
    private int number;
    private ParkingFloorStatus parkingFloorStatus;

}
