package ru.maxology.payments.yoomoney;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static ru.maxology.payments.yoomoney.TestUtil.getBody;

@QuarkusTest
@QuarkusTestResource(WireMockTestResource.class)
class YooMoneyResourceTest {

    @Test
    void getPaymentToken() {
        given()
                .body(getBody("request/payment-token-request.json"))
                .contentType("application/json")
                .when().post("/v1/payment/embedded/token")
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

}