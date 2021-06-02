package ru.maxology.payments.yoomoney.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class PaymentRequest extends DomainJson {
    private String idempotenceKey;
    private BigDecimal amount;
    private String description;

    @SneakyThrows
    public static PaymentRequest fromJsonString(String json) {
        return MAPPER.readValue(json, PaymentRequest.class);
    }
}
