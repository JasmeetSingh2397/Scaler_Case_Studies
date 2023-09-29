package models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Ticket extends BaseEntity{
    private Vehicle vehicle;
    private Date entryTime;
    private Operator operator;
    private Gate gate;
    private ParkingSpot parkingSpot;
}
