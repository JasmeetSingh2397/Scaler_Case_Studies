package Factories;

import Strategies.ElectricCarFeeCalculation;
import Strategies.FeeCalculationStrategy;
import Strategies.NormalCarFeeCalculation;
import models.*;

public class FeeCalculationFactory {
    public int getFee(Ticket ticket){
        if(ticket.getParkingSpot().getParkingSpotType().equals(ParkingSpotType.ELECTRIC)){
            ElectricCarFeeCalculation electricCarFeeCalculation= new ElectricCarFeeCalculation();
            EVParkingSpot evParkingSpot= (EVParkingSpot) ticket.getParkingSpot();
            return electricCarFeeCalculation.calculateFees(evParkingSpot.getMeter());
        }
        NormalCarFeeCalculation normalCarFeeCalculation= new NormalCarFeeCalculation();
        return normalCarFeeCalculation.calculateFees(null);
}}
