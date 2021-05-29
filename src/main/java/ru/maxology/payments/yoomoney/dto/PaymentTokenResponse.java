package ru.maxology.payments.yoomoney.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PaymentTokenResponse {
    @JsonProperty("confirmation-token")
    private String confirmationToken;
}
