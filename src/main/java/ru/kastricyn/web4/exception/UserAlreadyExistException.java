package ru.kastricyn.web4.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistException extends BaseException{
    public UserAlreadyExistException(String message) {
        super(message, "USER_ALREADY_EXIST_ERROR", HttpStatus.BAD_REQUEST);
    }
}
