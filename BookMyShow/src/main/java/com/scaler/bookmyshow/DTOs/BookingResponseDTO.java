package com.scaler.bookmyshow.DTOs;

import com.scaler.bookmyshow.Services.BookingService;
import com.scaler.bookmyshow.models.Booking;
import lombok.Getter;
import lombok.Setter;

import java.awt.print.Book;
@Getter
@Setter
public class BookingResponseDTO {
    private long bookingId;
    private int amount;

    private ResponseStatus responseStatus;
    private String FailureMessage;

}
