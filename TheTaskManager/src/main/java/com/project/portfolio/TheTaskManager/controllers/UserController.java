package com.project.portfolio.TheTaskManager.controllers;

import com.project.portfolio.TheTaskManager.entities.Task;
import com.project.portfolio.TheTaskManager.entities.User;
import com.project.portfolio.TheTaskManager.services.userServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task-manager/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get-all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(users);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        String result = userService.registerUser(user);

        if (result.startsWith("User registered successfully")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }


    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> optionalUser = userService.getUserById(id);
        return optionalUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/get-tasks-for-user/{userId}")
    public ResponseEntity<List<Task>> getTasksByUserId(@PathVariable Long userId) {
        if (!userService.getUserWithTasks(userId).isEmpty()) {
            return ResponseEntity.ok(userService.getUserWithTasks(userId));
        }
        return ResponseEntity.notFound().build();
    }



}