package ru.maxology.payments.yoomoney;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import ru.maxology.payments.yoomoney.dto.PaymentTokenRequest;
import ru.maxology.payments.yoomoney.rest.client.YooMoneyRestClient;
import ru.maxology.payments.yoomoney.rest.client.domain.EmbeddedPaymentRequest;
import ru.maxology.payments.yoomoney.rest.client.domain.EmbeddedPaymentResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class YooMoneyService {
    @Inject
    @RestClient
    YooMoneyRestClient yooMoneyRestClient;
    @Inject
    YooMoneyProperties yooMoneyProperties;

    public EmbeddedPaymentResponse getPayment(PaymentTokenRequest paymentTokenRequest) {
        return yooMoneyRestClient.getPayment(
                yooMoneyProperties.basicAuthorization(),
                paymentTokenRequest.getIdempotenceKey(),
                EmbeddedPaymentRequest.of(paymentTokenRequest)
        );
    }

}

