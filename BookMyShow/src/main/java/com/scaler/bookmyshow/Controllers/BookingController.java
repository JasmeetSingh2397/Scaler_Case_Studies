package com.scaler.bookmyshow.Controllers;

import com.scaler.bookmyshow.DTOs.BookingRequestDTO;
import com.scaler.bookmyshow.DTOs.BookingResponseDTO;
import com.scaler.bookmyshow.DTOs.ResponseStatus;
import com.scaler.bookmyshow.Exceptions.NoUserFoundException;
import com.scaler.bookmyshow.Exceptions.ShowNotFoundException;
import com.scaler.bookmyshow.Exceptions.ShowSeatNotAvailableException;
import com.scaler.bookmyshow.Services.BookingService;
import com.scaler.bookmyshow.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookingResponseDTO bookTicket(BookingRequestDTO bookingRequestDTO){
        BookingResponseDTO bookingResponseDTO= new BookingResponseDTO();
        try{
            Booking booking= bookingService.bookMovie(bookingRequestDTO.getUserId(),bookingRequestDTO.getShowId(),bookingRequestDTO.getShowSeatIds());
            bookingResponseDTO.setBookingId(booking.getId());
            bookingResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            bookingResponseDTO.setAmount(booking.getAmount());

        } catch (ShowNotFoundException | ShowSeatNotAvailableException | NoUserFoundException e) {
            bookingResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            System.out.println(e.getMessage());

        }
        return bookingResponseDTO;
    }

}
