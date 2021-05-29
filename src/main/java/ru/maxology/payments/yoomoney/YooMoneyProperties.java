package ru.maxology.payments.yoomoney;

import io.quarkus.arc.config.ConfigProperties;

import java.util.Base64;

@ConfigProperties(prefix = "yoomoney-api")
public class YooMoneyProperties {

    public String shopId;
    public String secretKey;

    public String basicAuthorization() {
        return "Basic " +
                Base64.getEncoder().encodeToString((shopId + ":" + secretKey).getBytes());
    }

}
