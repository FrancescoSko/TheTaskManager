package com.project.portfolio.TheTaskManager.services.userServices;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

@Service
public class UsernameValidationService {
    private static final Integer MIN_USERNAME_LENGTH = 3;
    private static final Integer MAX_USERNAME_LENGTH = 20;
    private static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_";

    public Boolean isUsernameValid(String username) {
        return isLengthValid(username) && containsOnlyAllowedCharacters(username);
    }

    private Boolean isLengthValid(String username) {
        int length = username.length();
        return length >= MIN_USERNAME_LENGTH && length <= MAX_USERNAME_LENGTH;
    }

    private Boolean containsOnlyAllowedCharacters(String username) {
        for (char character : username.toCharArray()) {
            if (ALLOWED_CHARACTERS.indexOf(character) == -1) {
                return false;
            }
        }
        return true;
    }




}













