package Controllers;

import Custom_Exceptions.NoParkingSpotFoundException;
import DTOs.ResponseStatus;
import DTOs.TicketRequestDTO;
import DTOs.TicketResponseDTO;
import Services.TicketService;
import models.Ticket;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public TicketResponseDTO generateTicket(TicketRequestDTO ticketRequestDTO){
        TicketResponseDTO ticketResponseDTO= new TicketResponseDTO();
        try{
            Ticket ticket= ticketService.generateTicket(ticketRequestDTO.getVehicleNumber(),
                    ticketRequestDTO.getVehicleType(),
                    ticketRequestDTO.getGateId());
            ticketResponseDTO.setTicket(ticket);
            ticketResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            return ticketResponseDTO;

        } catch (NoParkingSpotFoundException e) {
            ticketResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            ticketResponseDTO.setFailureMessage(e.getMessage());
            return ticketResponseDTO;

        }
        catch (Exception e){
            ticketResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            ticketResponseDTO.setFailureMessage(e.getMessage());
            return ticketResponseDTO;
        }


    }
}
