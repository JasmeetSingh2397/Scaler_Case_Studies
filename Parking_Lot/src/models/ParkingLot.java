package models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ParkingLot extends BaseEntity{
    private List<ParkingFloor> floors;
    private List<Gate> gates;
    private ParkingLotStatus parkingLotStatus;
    private String name;
    private String address;

}
