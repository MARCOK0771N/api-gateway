package com.eglobal.api_gateway.exception;

public class InvalidSecretException extends RuntimeException {
    public InvalidSecretException(String message) {
        super(message);
    }
}
