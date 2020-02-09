package com.facebook.exception;

public class FbUserExistsAlready extends FbBusinessException {

    public FbUserExistsAlready() {
    }

    public FbUserExistsAlready(String message, Throwable cause) {
        super(message, cause);
    }

    public FbUserExistsAlready(String user) {

    }
}
