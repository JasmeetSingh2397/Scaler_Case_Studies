package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle extends BaseEntity{
    private VehicleType vehicleType;
    private String number;

    public Vehicle( String number,VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        this.number = number;
    }

}
