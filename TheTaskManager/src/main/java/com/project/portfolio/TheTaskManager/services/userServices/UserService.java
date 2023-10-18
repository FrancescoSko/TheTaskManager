package com.project.portfolio.TheTaskManager.services.userServices;

import com.project.portfolio.TheTaskManager.entities.User;
import com.project.portfolio.TheTaskManager.repository.UserDAO;
import com.project.portfolio.TheTaskManager.services.userServices.UsernameValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PasswordValidation passwordValidation;
    @Autowired
    private UsernameValidationService usernameValidationService;
    @Autowired
    private EmailValidationService emailValidationService;

    public List<User> getAllUsers(){
        return userDAO.findAll();
    }

    public String registerUser(User user) {
        String password = user.getPassword();
        Boolean isPasswordValid = passwordValidation.isPasswordValid(user, password);
        Boolean isUsernameValid = usernameValidationService.isUsernameValid(user.getUserName());
        Boolean isEmailValid = emailValidationService.isEmailValid(user.getEmail());

        if (isPasswordValid && isUsernameValid && isEmailValid) {
            userDAO.save(user);
            return "User registered successfully";
        } else {
            StringBuilder errorMessage = new StringBuilder("Impossible to register. Errors:");

            if (!isUsernameValid) {
                errorMessage.append(" Invalid username;");
            }

            if (!isPasswordValid) {
                errorMessage.append(" Invalid password;");
            }

            if (!isEmailValid) {
                errorMessage.append(" Invalid email;");
            }
            return errorMessage.toString();
        }
    }


    public Optional<User> getUserById(Long id){
        for (User user: userDAO.findAll()){
            if(user.getId().equals(id)){
                return Optional.of(user);
            }
        } return Optional.empty();
    }





}

















