package Services;

import Factories.FeeCalculationFactory;
import Repositories.GateRepository;
import Repositories.TicketRepository;
import Strategies.ElectricCarFeeCalculation;
import Strategies.FeeCalculationStrategy;
import models.*;

import java.util.Date;

public class BillService {
    private TicketRepository ticketRepository;
    private GateRepository gateRepository;
    private FeeCalculationStrategy feeCalculationStrategy;

    public Bill generateBill(long ticketId, long gateId, PaymentMode paymentMode){
        Ticket ticket= ticketRepository.get(ticketId);
        Gate gate= ticket.getGate();
        VehicleType vehicleType= ticket.getVehicle().getVehicleType();

        FeeCalculationFactory feeCalculationFactory= new FeeCalculationFactory();
        int amount= feeCalculationFactory.getFee(ticket);
        Bill bill= new Bill();
        bill.setBillStatus(BillStatus.SUCCESS);
        bill.setAmount(amount);
        bill.setTicket(ticket);
        bill.setGate(gate);
        bill.setOperator(gate.getOperator());
        bill.setExitTime(new Date());

        return bill;






    }
}
