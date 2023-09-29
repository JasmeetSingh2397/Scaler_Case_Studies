package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gate extends BaseEntity{
    private int gateNumber;
    private Operator operator;
    private GateType gateType;
    private GateStatus gateStatus;
}
