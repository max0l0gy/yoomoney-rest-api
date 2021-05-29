package ru.maxology.payments.yoomoney;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class YooMoneyPropertiesTest {
    @Inject
    YooMoneyProperties yooMoneyProperties;

    @Test
    void configuration() {
        assertEquals("123", yooMoneyProperties.shopId);
        assertEquals("SUHDfsfsxmfnssDHSmvdysapg0vcjd", yooMoneyProperties.secretKey);
        assertEquals("Basic MTIzOlNVSERmc2ZzeG1mbnNzREhTbXZkeXNhcGcwdmNqZA==", yooMoneyProperties.basicAuthorization());

    }

}
