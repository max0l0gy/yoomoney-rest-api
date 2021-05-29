package ru.maxology.payments.yoomoney;

import lombok.extern.slf4j.Slf4j;
import ru.maxology.payments.yoomoney.dto.PaymentTokenResponse;
import ru.maxology.payments.yoomoney.dto.PaymentTokenRequest;
import ru.maxology.payments.yoomoney.dto.RestResponse;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Slf4j
@Path("/v1")
public class YooMoneyResource {

    @Inject
    YooMoneyService yooMoneyService;

    @POST
    @Path("/payment/embedded/token")
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<PaymentTokenResponse> getPaymentToken(PaymentTokenRequest paymentRequest) {
        return new RestResponse<PaymentTokenResponse>()
                .setStatus("success")
                .setData(yooMoneyService.getPayment(paymentRequest))
                ;
    }

}