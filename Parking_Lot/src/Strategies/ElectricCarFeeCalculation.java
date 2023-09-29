package Strategies;

import Repositories.TicketRepository;
import models.Meter;
import models.Ticket;

public class ElectricCarFeeCalculation implements FeeCalculationStrategy{





    @Override
    public int calculateFees(Meter meter) {

        return 50 + meter.getRatePerUnit()*meter.getUnitsConsumed() ;

    }
}
