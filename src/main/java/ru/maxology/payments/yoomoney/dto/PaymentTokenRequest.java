package ru.maxology.payments.yoomoney.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class PaymentTokenRequest extends DomainJson {
    private String idempotenceKey;
    private BigDecimal amount;
    private String description;

    @SneakyThrows
    public static PaymentTokenRequest fromJsonString(String json) {
        return MAPPER.readValue(json, PaymentTokenRequest.class);
    }
}
