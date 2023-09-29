package DTOs;

import com.sun.net.httpserver.Authenticator;
import models.Bill;

public class BillResponseDTO {
    private Bill bill;
    private ResponseStatus responseStatus;

    private String FailureMessage;

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
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
}
