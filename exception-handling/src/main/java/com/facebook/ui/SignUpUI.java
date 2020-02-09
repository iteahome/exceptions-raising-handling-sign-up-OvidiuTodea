package com.facebook.ui;

import com.facebook.exception.FacebookException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.exception.FbUserExistsAlready;
import com.facebook.exception.FbWrongCredentialsException;
import com.facebook.model.User;
import com.facebook.service.UserService;
import com.facebook.ui.validator.UserValidator;

import java.util.Scanner;

public class SignUpUI {

    private UserService userService = new UserService();
    private UserValidator userValidator = new UserValidator();

    public void displaySignUp() {
        User userToAdd = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the email with which you want to register: ");
        String email = scanner.nextLine();
        System.out.println("Enter the password associated with the email: ");
        String password = scanner.nextLine();

        try {
            userValidator.validateUserCredentials(email, password);
            userToAdd.setEmail(email);
            userToAdd.setPassword(password);
            userService.signUp(userToAdd);
            System.out.println("User " + email +" is successfully registered now!!! ");

        } catch (FbUserExistsAlready e){
            System.out.println("User already exists! ");
        } catch (FbWrongCredentialsException e) {
            System.out.println("Invalid credentials ! ");
        } catch (FbTechnicalException e) {
            e.printStackTrace();
            System.out.println("A system error appeared. Please contact your administrator");
        } catch (FacebookException e) {
            e.printStackTrace();
        }
    }
}
