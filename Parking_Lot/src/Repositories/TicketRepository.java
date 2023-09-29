package Repositories;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    private Map<Long, Ticket> ticketStore;

    public TicketRepository() {
        this.ticketStore = new HashMap<>();
    }

    public Ticket save(Ticket ticket){
        ticketStore.put(ticket.getId(),ticket);
        return ticket;
    }

    public Ticket get(long ticketId){
        return ticketStore.get(ticketId);
    }
}
