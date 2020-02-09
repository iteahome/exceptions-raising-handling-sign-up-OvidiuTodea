package com.facebook.ui.validator;

import com.facebook.exception.FbWrongCredentialsException;


public class UserValidator {

    public void validateUserCredentials(String email, String password) throws FbWrongCredentialsException {

        if ((password.length() < 6) || (!email.contains("@")) || (!email.contains("."))|| (email.length()<5))
            throw new FbWrongCredentialsException();

    }
}
