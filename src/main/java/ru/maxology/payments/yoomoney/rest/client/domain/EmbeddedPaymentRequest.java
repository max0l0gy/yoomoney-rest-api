package ru.maxology.payments.yoomoney.rest.client.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;
import ru.maxology.payments.yoomoney.dto.DomainJson;
import ru.maxology.payments.yoomoney.dto.PaymentRequest;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class EmbeddedPaymentRequest extends DomainJson {
    Amount amount;
    Confirmation confirmation;
    Boolean capture;
    String description;

    @SneakyThrows
    public static EmbeddedPaymentRequest fromJsonString(String jsonReq) {
        return MAPPER.readValue(jsonReq, EmbeddedPaymentRequest.class);
    }

    public static EmbeddedPaymentRequest of(PaymentRequest paymentRequest) {
        return new EmbeddedPaymentRequest()
                .setAmount(new Amount()
                        .setCurrency("RUB")
                        .setValue(paymentRequest.getAmount())
                )
                .setCapture(true)
                .setDescription(paymentRequest.getIdempotenceKey())
                .setConfirmation(new Confirmation().setType(Confirmation.EMBEDDED))
                ;
    }
}
