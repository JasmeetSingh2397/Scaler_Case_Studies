package DTOs;

import models.Ticket;

public class TicketResponseDTO {
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getFailureMessage() {
        return FailureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        FailureMessage = failureMessage;
    }

    private ResponseStatus responseStatus;
    private String FailureMessage;


}
