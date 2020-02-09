package com.facebook.exception;

public class FbBusinessException extends FacebookException {

    public FbBusinessException() {
    }

    public FbBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
