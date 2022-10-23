package com.rso.microservice.util;

import com.rso.microservice.exceptions.PasswordsDontMatchException;

public class ValidationUtil {

    public static void checkPasswordMatch(String password, String repeatPassword) {
        if (!password.equals(repeatPassword))
            throw new PasswordsDontMatchException("Password and repeatPassword don't match");
    }

}
