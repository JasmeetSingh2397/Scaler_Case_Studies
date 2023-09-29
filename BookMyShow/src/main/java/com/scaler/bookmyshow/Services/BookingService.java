package com.scaler.bookmyshow.Services;

import com.scaler.bookmyshow.Exceptions.NoUserFoundException;
import com.scaler.bookmyshow.Exceptions.ShowNotFoundException;
import com.scaler.bookmyshow.Exceptions.ShowSeatNotAvailableException;
import com.scaler.bookmyshow.Repositories.BookingRepository;
import com.scaler.bookmyshow.Repositories.ShowRepository;
import com.scaler.bookmyshow.Repositories.ShowSeatRepository;
import com.scaler.bookmyshow.Repositories.UserRepository;
import com.scaler.bookmyshow.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;

    private BookingRepository bookingRepository;
    private PriceCalculatorService priceCalculatorService;

    @Autowired
    public BookingService(UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                          BookingRepository bookingRepository,
                          PriceCalculatorService priceCalculatorService) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
        this.priceCalculatorService = priceCalculatorService;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, Long showId, List<Long> showSeatIds) throws NoUserFoundException, ShowNotFoundException, ShowSeatNotAvailableException {
        /*
        ---------------TAKE A LOCK-----------------------
        1.Get the user from the userId
        2.Get the Show from the showId
        3.Get the showSeats from the showSeatIds
        4.Check if all the showSeats are available
        5.If all the show seats are not available, then throw an exception
        6.If all are available, then change the status to be locked.
        7.Change the status in the DB as well
        8.Create the Booking object and store it in the DB
        9.Return the Booking object.
        ----------------RELEASE THE LOCK-----------------
         */
        //Get the user from userId.
        Optional<User> optionalUser= userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new NoUserFoundException("Invalid UserId");

        }
        User bookedBy= optionalUser.get();

        //Get the show
        Optional<Show> optionalShow= showRepository.findById(showId);
        if(optionalShow.isEmpty()){
            throw new ShowNotFoundException("Invalid Show Id");
        }
        Show show= optionalShow.get();

        //Get the showSeats from the showSeat Ids

        List<ShowSeat> showSeats= showSeatRepository.findAllById(showSeatIds);

        for(ShowSeat showSeat:showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new ShowSeatNotAvailableException("ShowSeat with id: "+ showSeat.getId() + " isn't available.");
            }
        }
        //Change the status to be locked.

        for(ShowSeat showSeat:showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatRepository.save(showSeat);
        }
        Booking booking= new Booking();
        booking.setUser(bookedBy);
        booking.setBookingStatus(BookingStatus.IN_PROGRESS);
        booking.setPayments(new ArrayList<>());
        booking.setShowSeats(showSeats);
        booking.setCreatedAt(new Date());
        booking.setLastModified(new Date());
        booking.setAmount(priceCalculatorService.calculateBookingPrice(showSeats, show));

        return bookingRepository.save(booking);
    }
}
