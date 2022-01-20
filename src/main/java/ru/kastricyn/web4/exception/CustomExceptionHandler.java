package ru.kastricyn.web4.exception;

import lombok.NonNull;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.kastricyn.web4.dto.ExceptionDto;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@ResponseBody
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {
            NotFoundDataException.class,
            UserAlreadyExistException.class,
            WrongTokenException.class,
            WrongPasswordException.class
    })
    protected ResponseEntity<Object> handleError(BaseException ex, WebRequest request) {
        logger.error("Exception in occurred", ex);
        SecurityContextHolder.clearContext();
        return handleExceptionInternal(
                ex,
                new ExceptionDto(ex.getErrorCode(), ex.getMessage()),
                new HttpHeaders(), ex.getHttpStatus(),
                request);
    }


    @NonNull
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  @NonNull HttpHeaders headers,
                                                                  @NonNull HttpStatus status,
                                                                  @NonNull WebRequest request) {
        List<ExceptionDto> errors = new ArrayList<>(ex.getFieldErrors().size());
        for (FieldError error : ex.getFieldErrors()) {
            errors.add(new ExceptionDto(
                    HttpStatus.BAD_REQUEST.name(),
                    String.format(
                            "Поле %s - %s",
                            error.getField(),
                            error.getDefaultMessage())));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }
}
