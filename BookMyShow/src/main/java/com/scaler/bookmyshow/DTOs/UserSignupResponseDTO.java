package com.scaler.bookmyshow.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignupResponseDTO {
    private Long UserId;
    private String FailureMessage;
    private ResponseStatus responseStatus;
}
