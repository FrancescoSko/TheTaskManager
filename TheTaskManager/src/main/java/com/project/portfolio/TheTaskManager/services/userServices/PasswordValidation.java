package com.project.portfolio.TheTaskManager.services.userServices;

import com.project.portfolio.TheTaskManager.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordValidation {
    @Autowired
    UsernameValidationService usernameValidationService;
    private static final Integer MIN_PASSWORD_LENGTH = 8;
    private static final Integer MAX_PASSWORD_LENGTH = 14;
    private static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_?!";

    public boolean isPasswordValid(User user, String password) {
        if (!isLengthValid(password)) {
            return false;
        }
        else if (!containsOnlyAllowedCharacters(password)) {
            return false;
        }
        else if (password.toLowerCase().contains(user.getUserName().toLowerCase())) {
            return false;
        }
        return true;
    }


    private boolean isLengthValid(String password) {
        int length = password.length();
        return length >= MIN_PASSWORD_LENGTH && length <= MAX_PASSWORD_LENGTH;
    }

    private boolean containsOnlyAllowedCharacters(String password) {
        for (Character character : password.toCharArray()) {
            if (ALLOWED_CHARACTERS.indexOf(character) == -1) {
                return false;
            }
        }
        return true;
    }




}
