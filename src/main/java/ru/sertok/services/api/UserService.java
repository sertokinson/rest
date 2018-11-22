package ru.sertok.services.api;


import ru.sertok.form.LoginForm;
import ru.sertok.models.User;
import ru.sertok.transfer.TokenDto;

import java.util.List;

public interface UserService {
    void signUp(User user);
    TokenDto signIn(LoginForm loginForm);
    List<User> findAll();
}
