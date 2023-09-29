package Controllers;

import DTOs.BillRequestDTO;
import DTOs.BillResponseDTO;
import DTOs.ResponseStatus;
import Services.BillService;
import models.Bill;

public class BillController {
    private BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    public BillResponseDTO generateBill(BillRequestDTO billRequestDTO){

        BillResponseDTO billResponseDTO= new BillResponseDTO();
        Bill bill = billService.generateBill(billRequestDTO.getTicketId(),billRequestDTO.getGateId(),billRequestDTO.getPaymentMode());
        billResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        billResponseDTO.setBill(bill);
        return billResponseDTO;


    }
}
