package ru.maxology.payments.yoomoney;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.Header;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static ru.maxology.payments.yoomoney.TestUtil.getBody;

@QuarkusTest
@QuarkusTestResource(WireMockTestResource.class)
class YooMoneyResourceTest {

    @Test
    void initial() {
        given()
                .body(getBody("request/payment-token-request.json"))
                .contentType("application/json")
                .when().post("/v1/payments")
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("status", is("success"))
                .body("data.id", is("2840bb6e-000f-5000-a000-151e92335af3"))
                .body("data.status", is("pending"))
                .body("data.paid", is(false))
                .body("data.amount.value", is(2.0f))
                .body("data.amount.currency", is("RUB"))
                .body("data.created_at", is("2021-05-26T19:55:26.472Z"))
                .body("data.confirmation.confirmation_token", is("ct-2840bb6e-000f-5000-a000-151e92335af3"))
        ;
    }

    @Test
    void getPaymentInfo() {
        given()
                .when().get("/v1/payments/2840bb6e-000f-5000-a000-151e92335af3")
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("status", is("success"))
                .body("data.id", is("2840bb6e-000f-5000-a000-151e92335af3"))
                .body("data.status", is("succeeded"))
                .body("data.paid", is(true))
                .body("data.amount.value", is(2.0f))
                .body("data.amount.currency", is("RUB"))
                .body("data.created_at", is("2021-05-26T19:55:26.472Z"))
                .body("data.confirmation", nullValue())
        ;
    }

    @Test
    void refunds() {
        given()
                .header(new Header("Idempotence-Key","100"))
                .body(getBody("request/refund-request.json"))
                .contentType("application/json")
                .when().post("/v1/refunds")
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("status", is("success"))
                .body("data.id", is("216749f7-0016-50be-b000-078d43a63ae4"))
                .body("data.status", is("succeeded"))
                .body("data.amount.value", is(2.0f))
                .body("data.amount.currency", is("RUB"))
                .body("data.created_at", is("2017-10-04T19:27:51.407Z"))
                .body("data.payment_id", is("216749da-000f-50be-b000-096747fad91e"))
        ;
    }

}