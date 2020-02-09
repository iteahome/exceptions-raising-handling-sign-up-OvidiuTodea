package com.facebook.exception;

public class FbTechnicalException extends FacebookException {

    public FbTechnicalException(String message, Throwable cause) {
        super(message, cause);
    }
}
