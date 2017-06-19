package com.bhupen.dlgdemo.Shared;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Bhupen on 18/06/2017.
 */

public class Validation {

    private static final int PASSWORD_LENGTH = 8;

    private static final String EMAIL_PATTERN =
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";


    private static final String PASSWORD_PATTERN = "^(?=.*\\d).{8,}$";

    private Pattern email_pattern = Pattern.compile(EMAIL_PATTERN);

    private Pattern password_pattern = Pattern.compile(PASSWORD_PATTERN);
    private Matcher matcher;

    //STRING VALIDATION
    public boolean checkForValidString(String stringToTest){
        if(stringToTest == null || stringToTest.trim().length() == 0){
            return false;
        }
        else{
            return true;
        }
    }


    //EMAIL VALIDATION
    public boolean checkForValidEmail(String email){
        matcher = email_pattern.matcher(email);
        return matcher.matches();
    }

    //PASSWORD VALIDATION
    public boolean checkForValidPassword(String password){
        matcher = password_pattern.matcher(password);
        return matcher.matches();
    }


}
