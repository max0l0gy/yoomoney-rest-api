package ru.maxology.payments.yoomoney.rest.client;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }

}
