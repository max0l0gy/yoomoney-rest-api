package ru.maxology.payments.yoomoney;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import ru.maxology.payments.yoomoney.dto.PaymentRequest;
import ru.maxology.payments.yoomoney.rest.client.domain.EmbeddedPaymentResponse;

import javax.inject.Inject;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.maxology.payments.yoomoney.TestUtil.getBody;

@QuarkusTest
@QuarkusTestResource(WireMockTestResource.class)
class YooMoneyServiceTest {

    @Inject
    YooMoneyService yooMoneyService;

    @Test
    void initial() {
        PaymentRequest paymentRequest = PaymentRequest.fromJsonString(getBody("request/payment-token-request.json"));
        EmbeddedPaymentResponse paymentResponse = yooMoneyService.initial(paymentRequest);
        assertEquals(
                "ct-2840bb6e-000f-5000-a000-151e92335af3",
                paymentResponse.getConfirmation().getConfirmationToken()
        );
        assertEquals(
                "2021-05-26T19:55:26.472Z",
                paymentResponse.getCreatedAt().toString()
        );
        assertEquals("pending", paymentResponse.getStatus());
        assertEquals("2840bb6e-000f-5000-a000-151e92335af3", paymentResponse.getId());
        assertFalse(paymentResponse.getPaid());
        assertEquals(0, paymentResponse.getAmount().getValue().compareTo(BigDecimal.valueOf(2.00)));
        assertEquals("RUB", paymentResponse.getAmount().getCurrency());
    }

    @Test
    void getPayment() {
        EmbeddedPaymentResponse paymentResponse = yooMoneyService.getPayment("2840bb6e-000f-5000-a000-151e92335af3");
        assertNull(paymentResponse.getConfirmation());
        assertEquals(
                "2021-05-26T19:55:26.472Z",
                paymentResponse.getCreatedAt().toString()
        );
        assertEquals("succeeded", paymentResponse.getStatus());
        assertEquals("2840bb6e-000f-5000-a000-151e92335af3", paymentResponse.getId());
        assertTrue(paymentResponse.getPaid());
        assertEquals(0, paymentResponse.getAmount().getValue().compareTo(BigDecimal.valueOf(2.00)));
        assertEquals("RUB", paymentResponse.getAmount().getCurrency());
    }

    @Test
    void refund() {
        PaymentRequest paymentRequest = PaymentRequest.fromJsonString(getBody("request/payment-token-request.json"));
        EmbeddedPaymentResponse paymentResponse = yooMoneyService.initial(paymentRequest);
        assertEquals(
                "ct-2840bb6e-000f-5000-a000-151e92335af3",
                paymentResponse.getConfirmation().getConfirmationToken()
        );
        assertEquals(
                "2021-05-26T19:55:26.472Z",
                paymentResponse.getCreatedAt().toString()
        );
        assertEquals("pending", paymentResponse.getStatus());
        assertEquals("2840bb6e-000f-5000-a000-151e92335af3", paymentResponse.getId());
        assertFalse(paymentResponse.getPaid());
        assertEquals(0, paymentResponse.getAmount().getValue().compareTo(BigDecimal.valueOf(2.00)));
        assertEquals("RUB", paymentResponse.getAmount().getCurrency());
    }

}
