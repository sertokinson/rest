package ru.sertok.exceptions;

public class TokenException extends RuntimeException  {
    public TokenException() {
        super("Не валидный token!");
    }
}
