package ru.kastricyn.web4.exception;

import org.springframework.http.HttpStatus;

public class WrongTokenException extends BaseException{
    public WrongTokenException(String message) {
        super(message, "WRONG_TOKEN_ERROR", HttpStatus.UNAUTHORIZED);
    }
}
