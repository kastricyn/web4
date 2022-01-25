package ru.kastricyn.web4.exception;

import org.springframework.http.HttpStatus;

public class NotFoundDataException extends BaseException {
    public NotFoundDataException(String message) {
        super(message, "NOT_FOUND_DATA_ERROR", HttpStatus.BAD_REQUEST);
    }
}
