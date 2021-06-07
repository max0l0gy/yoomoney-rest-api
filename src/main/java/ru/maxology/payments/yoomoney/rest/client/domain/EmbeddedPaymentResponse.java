package ru.maxology.payments.yoomoney.rest.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import ru.maxology.payments.yoomoney.dto.DomainJson;

import java.time.Instant;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmbeddedPaymentResponse extends DomainJson {
    public static final String PENDING = "pending";
    public static final String WAITING_FOR_CAPTURE = "waiting_for_capture";
    public static final String SUCCEEDED = "succeeded";

    private String id;
    private String status;
    private Boolean paid;
    private Amount amount;
    private Confirmation confirmation;
    @JsonProperty("created_at")
    private Instant createdAt;
    private String description;

}
