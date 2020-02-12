package com.facebook.dao;

import com.facebook.exception.FacebookException;
import com.facebook.exception.FbFileException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDAO {

    private static final String USERS_FILE = "D:\\ITeaHome\\Exceptions\\exception-handling\\exception-handling\\src\\main\\resources\\users.txt";

    public List<User> readAllUsers() throws FbTechnicalException {
        List<User> userList = new ArrayList<>();
        Scanner scannerText=null;
        try {
            scannerText=new Scanner(new BufferedReader(new FileReader(USERS_FILE)));
            String userLine="";
            while(scannerText.hasNextLine()){
                userLine = scannerText.nextLine();
                String[] userValues = userLine.split(";");

                userList.add(new User(userValues[0], userValues[1]));
            }
        } catch (IOException e) {
            throw new FbFileException("Error reading users", e);
        }
        return userList;
    }

    public void writeUserToFile(User user) throws FbTechnicalException {

        try (FileWriter fileWriter = new FileWriter(USERS_FILE, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.newLine();
            bufferedWriter.write(user.getEmail());
            bufferedWriter.write(";");
            bufferedWriter.write(user.getPassword());
        } catch (IOException e) {
            throw new FbFileException("Error writing user to file", e);
        }
    }
}