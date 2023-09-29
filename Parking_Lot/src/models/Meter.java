package models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Meter extends BaseEntity{
    private Date startTime;
    private Date endTime;
    private int unitsConsumed;
    private int ratePerUnit;

}
