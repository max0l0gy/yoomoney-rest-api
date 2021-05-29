package ru.maxology.payments.yoomoney;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import ru.maxology.payments.yoomoney.dto.PaymentTokenRequest;
import ru.maxology.payments.yoomoney.dto.PaymentTokenResponse;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.maxology.payments.yoomoney.TestUtil.getBody;

@QuarkusTest
@QuarkusTestResource(WireMockTestResource.class)
class YooMoneyServiceTest {

    @Inject
    YooMoneyService yooMoneyService;

    @Test
    void getPayment() {
        PaymentTokenRequest paymentTokenRequest = PaymentTokenRequest.fromJsonString(getBody("request/payment-token-request.json"));
        PaymentTokenResponse paymentResponse = yooMoneyService.getPayment(paymentTokenRequest);
        assertEquals(
                "ct-2840bb6e-000f-5000-a000-151e92335af3",
                paymentResponse.getConfirmationToken()
        );
    }

}
