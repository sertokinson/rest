package ru.sertok.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sertok.models.User;
import ru.sertok.services.api.UserService;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        userService.signUp(user);
        return ResponseEntity.ok().build();
    }
}
