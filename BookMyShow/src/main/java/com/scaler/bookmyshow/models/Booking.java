package com.scaler.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    @ManyToMany
    private List<ShowSeat> showSeats;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Payment> payments;

    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;



}
