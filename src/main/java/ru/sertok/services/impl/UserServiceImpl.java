package ru.sertok.services.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.sertok.exceptions.PasswordException;
import ru.sertok.exceptions.UserException;
import ru.sertok.form.LoginForm;
import ru.sertok.models.Role;
import ru.sertok.models.State;
import ru.sertok.models.Token;
import ru.sertok.models.User;
import ru.sertok.repositories.TokenRepository;
import ru.sertok.repositories.UsersRepository;
import ru.sertok.services.api.UserService;
import ru.sertok.transfer.TokenDto;

import java.util.List;

import static ru.sertok.transfer.TokenDto.from;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public void signUp(User user) {
        user.setRole(Role.USER);
        user.setState(State.ACTIVE);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
    }

    @Override
    public TokenDto signIn(LoginForm loginForm) {
        return usersRepository.findByName(loginForm.getName())
                .filter(user -> {
                    if(passwordEncoder.matches(loginForm.getPassword(), user.getPassword()))
                        return true;
                    throw new PasswordException();
                })
                .map(user -> Token.builder().user(user).value(RandomStringUtils.random(10, true, true)).build())
                .map(token -> {
                    tokenRepository.save(token);
                    return from(token);
                }).orElseThrow(UserException::new);
    }

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }
}
