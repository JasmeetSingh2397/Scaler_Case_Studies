package com.scaler.bookmyshow.Services;

import com.scaler.bookmyshow.Repositories.ShowSeatTypeRepository;
import com.scaler.bookmyshow.models.SeatType;
import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.models.ShowSeat;
import com.scaler.bookmyshow.models.ShowSeatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PriceCalculatorService {
    private ShowSeatTypeRepository showSeatTypeRepository;
    @Autowired
    public PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int calculateBookingPrice(List<ShowSeat> showSeats, Show show){
        int amount=0;
        List<ShowSeatType> showSeatTypes= showSeatTypeRepository.findAllByShow(show.getId());
        Map<SeatType,Integer> SeatTypePriceMap= new HashMap<>();
        for(ShowSeatType showSeatType:showSeatTypes){
            SeatTypePriceMap.put(showSeatType.getSeatType(),showSeatType.getPrice());
        }
        for(ShowSeat showSeat:showSeats){
            amount+=(SeatTypePriceMap.get(showSeat.getSeat().getSeatType()));
        }
        return amount;
    }

}
