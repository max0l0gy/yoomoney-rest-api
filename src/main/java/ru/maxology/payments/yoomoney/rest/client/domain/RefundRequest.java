package ru.maxology.payments.yoomoney.rest.client.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;
import ru.maxology.payments.yoomoney.dto.DomainJson;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class RefundRequest extends DomainJson {
    private Amount amount;
    @JsonProperty("payment_id")
    private String paymentId;

    @SneakyThrows
    public static RefundRequest fromJsonString(String json) {
        return MAPPER.readValue(json, RefundRequest.class);
    }
}
