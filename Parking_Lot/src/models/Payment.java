package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseEntity{
    private PaymentMode paymentMode;
    private int amount;
    private PaymentStatus paymentStatus;
    private String referenceID;

}
