package ru.maxology.payments.yoomoney.rest.client.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import ru.maxology.payments.yoomoney.dto.DomainJson;

import java.time.Instant;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class RefundResponse extends DomainJson {
    public static final String CANCELED = "canceled";
    public static final String SUCCEEDED = "succeeded";

    private String id;
    private String status;
    private Amount amount;
    @JsonProperty("created_at")
    private Instant createdAt;
    @JsonProperty("payment_id")
    private String paymentId;

}
