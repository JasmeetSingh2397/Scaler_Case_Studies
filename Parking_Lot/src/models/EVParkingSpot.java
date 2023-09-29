package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EVParkingSpot extends ParkingSpot{
    private Meter meter;
}
