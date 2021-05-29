package ru.maxology.payments.yoomoney.rest.client.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;
import ru.maxology.payments.yoomoney.dto.DomainJson;
import ru.maxology.payments.yoomoney.dto.PaymentTokenRequest;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class EmbeddedPaymentRequest extends DomainJson {
    Amount amount;
    Confirmation confirmation;
    String description;

    @SneakyThrows
    public static EmbeddedPaymentRequest fromJsonString(String jsonReq) {
        return MAPPER.readValue(jsonReq, EmbeddedPaymentRequest.class);
    }

    public static EmbeddedPaymentRequest of(PaymentTokenRequest paymentTokenRequest) {
        return new EmbeddedPaymentRequest()
                .setAmount(new Amount()
                        .setCurrency("RUB")
                        .setValue(paymentTokenRequest.getAmount())
                )
                .setDescription(paymentTokenRequest.getIdempotenceKey())
                .setConfirmation(new Confirmation()
                        .setType(Confirmation.EMBEDDED)
                )
                ;
    }
}
