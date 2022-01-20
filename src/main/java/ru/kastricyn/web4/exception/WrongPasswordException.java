package ru.kastricyn.web4.exception;

import org.springframework.http.HttpStatus;

public class WrongPasswordException extends BaseException {
    public WrongPasswordException(String message) {
        super(message, "WRONG_PASSWORD_ERROR", HttpStatus.UNAUTHORIZED);
    }
}
