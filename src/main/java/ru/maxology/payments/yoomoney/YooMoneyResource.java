package ru.maxology.payments.yoomoney;

import lombok.extern.slf4j.Slf4j;
import ru.maxology.payments.yoomoney.dto.PaymentRequest;
import ru.maxology.payments.yoomoney.dto.RestResponse;
import ru.maxology.payments.yoomoney.rest.client.domain.EmbeddedPaymentResponse;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Slf4j
@Path("/v1")
public class YooMoneyResource {

    @Inject
    YooMoneyService yooMoneyService;

    @POST
    @Path("/payments")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<EmbeddedPaymentResponse> initial(PaymentRequest paymentRequest) {
        return new RestResponse<EmbeddedPaymentResponse>()
                .setStatus("success")
                .setData(yooMoneyService.initial(paymentRequest))
                ;
    }

    @GET
    @Path("/payments/{paymentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<EmbeddedPaymentResponse> getPayment(@PathParam("paymentId") String paymentId) {
        return new RestResponse<EmbeddedPaymentResponse>()
                .setStatus("success")
                .setData(yooMoneyService.getPayment(paymentId))
                ;
    }

}