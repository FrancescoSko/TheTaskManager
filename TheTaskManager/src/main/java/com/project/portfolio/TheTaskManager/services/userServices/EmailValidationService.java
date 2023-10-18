package com.project.portfolio.TheTaskManager.services.userServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmailValidationService {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public Boolean isEmailValid(String email) {
        return email.matches(EMAIL_REGEX);
    }
}

