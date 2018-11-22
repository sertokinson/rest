package ru.sertok.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sertok.models.User;
import ru.sertok.services.api.UserService;
import ru.sertok.transfer.UserDto;

import java.util.List;

import static ru.sertok.transfer.UserDto.from;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return from(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        userService.signUp(user);
        return ResponseEntity.ok().build();
    }
}
