package ru.sertok.exceptions;

public class PasswordException extends RuntimeException {
    public PasswordException() {
        super("Неверный пароль!");
    }
}
