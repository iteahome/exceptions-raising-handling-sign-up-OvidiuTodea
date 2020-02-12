package com.facebook.service;

import com.facebook.dao.UserDAO;
import com.facebook.exception.FacebookException;
import com.facebook.exception.FbUserExistsAlready;
import com.facebook.exception.FbWrongCredentialsException;
import com.facebook.model.User;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public User login(String inputEmail, String inputPassword) throws FacebookException {
        for (User user : userDAO.readAllUsers()) {
            if (inputEmail.equals(user.getEmail()) && inputPassword.equals(user.getPassword())) {
                return user;
            }
        }
        throw new FbWrongCredentialsException();
    }

    public void signUp(User addedUser) throws FacebookException {

        boolean userExists = false;
        for (User user : userDAO.readAllUsers()) {
            if (addedUser.getEmail().equalsIgnoreCase(user.getEmail())) {
                userExists = true;
               throw new FbUserExistsAlready();
            }
        }

        if (!userExists) {
            userDAO.writeUserToFile(addedUser);
        }
    }
}

