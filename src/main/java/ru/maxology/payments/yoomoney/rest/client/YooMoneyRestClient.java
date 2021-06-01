package ru.maxology.payments.yoomoney.rest.client;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import ru.maxology.payments.yoomoney.rest.client.domain.EmbeddedPaymentRequest;
import ru.maxology.payments.yoomoney.rest.client.domain.EmbeddedPaymentResponse;
import ru.maxology.payments.yoomoney.rest.client.domain.RefundRequest;
import ru.maxology.payments.yoomoney.rest.client.domain.RefundResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@RegisterRestClient(configKey = "yoomoney-api")
@RegisterProvider(UnauthorizedExceptionMapper.class)
public interface YooMoneyRestClient {

    @POST
    @Path("/v3/payments")
    @Produces(MediaType.APPLICATION_JSON)
    EmbeddedPaymentResponse initial(
            @HeaderParam("Authorization") String authorization,
            @HeaderParam("Idempotence-Key") String idempotenceKey,
            EmbeddedPaymentRequest embeddedPaymentRequest
    );

    @GET
    @Path("/v3/payments/{paymentId}")
    @Produces(MediaType.APPLICATION_JSON)
    EmbeddedPaymentResponse getPayment(
            @HeaderParam("Authorization") String authorization,
            @PathParam("paymentId") String paymentId
    );

    @POST
    @Path("/v3/refunds")
    @Produces(MediaType.APPLICATION_JSON)
    RefundResponse refund(
            @HeaderParam("Authorization") String authorization,
            @HeaderParam("Idempotence-Key") String idempotenceKey,
            RefundRequest refundRequest
    );

}
