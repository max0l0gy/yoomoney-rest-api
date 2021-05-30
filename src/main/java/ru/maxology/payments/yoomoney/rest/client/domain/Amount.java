package ru.maxology.payments.yoomoney.rest.client.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class Amount {
    private  BigDecimal value;
    private String currency = "RUB";
}
