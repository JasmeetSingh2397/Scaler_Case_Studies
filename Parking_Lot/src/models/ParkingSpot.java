package models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ParkingSpot extends BaseEntity{
    private List<VehicleType> supportedvehicleTypes;

    private ParkingSpotStatus parkingSpotStatus;

    private ParkingFloor parkingFloor;

    private ParkingSpotType parkingSpotType;

    private int number;

}
