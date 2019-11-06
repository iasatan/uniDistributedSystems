package com.example.autonyilvantartologic.exception;

public class InvalidCarException extends Exception {
    public InvalidCarException() {
    }

    public InvalidCarException(String message) {
        super(message);
    }

    public InvalidCarException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCarException(Throwable cause) {
        super(cause);
    }

    public InvalidCarException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
