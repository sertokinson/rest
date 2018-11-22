package ru.sertok.exceptions;

public class UserException extends RuntimeException {
    public UserException() {
        super("Не найден пользователь!");
    }
}
