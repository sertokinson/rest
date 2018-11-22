package ru.sertok.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.sertok.form.LoginForm;
import ru.sertok.services.api.UserService;
import ru.sertok.transfer.TokenDto;

import javax.servlet.http.HttpServletRequest;


@RestController
public class SignInController {
    @Autowired
    private UserService userService;

    @PostMapping("/signIn")
    public ResponseEntity<TokenDto> signIn(@RequestBody LoginForm loginForm) {
        return ResponseEntity.ok(userService.signIn(loginForm));
    }

}
