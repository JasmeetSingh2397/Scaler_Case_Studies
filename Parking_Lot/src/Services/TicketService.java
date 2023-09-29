package Services;

import Custom_Exceptions.NoParkingSpotFoundException;
import Repositories.TicketRepository;
import Repositories.VehicleRepository;
import models.*;

import java.util.Date;

public class TicketService {
    private VehicleService vehicleService;
    private GateService gateService;
    private ParkingLotService parkingLotService;
    private ParkingSpotService parkingSpotService;

    private TicketRepository ticketRepository;


    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType, Long gateId) throws NoParkingSpotFoundException {
        //Flow
        //1. Get the vehicle from the DB using VehicleNumber
        //2. If Vehicle Not found, then create a new entry

        Vehicle vehicle= vehicleService.getVehicle(vehicleNumber);// ask where us this vehicleService object getting initialized, otherwise it will be null, because there is no constructor.
        if (vehicle==null){
            vehicle= vehicleService.registerVehicle(vehicleNumber,vehicleType);
        }

        //Get the gate of the ticket
        Gate gate= gateService.getGate(gateId);

        ParkingSpot parkingSpot= parkingLotService.getParkingSpot(vehicle,gate);
        if (parkingSpot==null){
            throw new NoParkingSpotFoundException("No Parking Spot Available");
        }

        //Update the parking spot as occupied.

        parkingSpot= parkingSpotService.assignParkingSpot(parkingSpot);

        //Create Ticket

        Ticket ticket= new Ticket();
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());
        ticket.setParkingSpot(parkingSpot);
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(new Date());

        ticketRepository.save(ticket);

        return ticket;




    }
}
