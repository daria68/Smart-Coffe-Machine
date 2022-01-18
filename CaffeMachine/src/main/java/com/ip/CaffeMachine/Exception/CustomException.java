package com.ip.CaffeMachine.Exception;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}