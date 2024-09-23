package ru.solonchev.phonecontact.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.solonchev.phonecontact.dto.response.ErrorDto;
import ru.solonchev.phonecontact.exception.BackendException;
import ru.solonchev.phonecontact.exception.UserNotFoundException;

@RestControllerAdvice
public class ExceptionApiHandler {

    @ExceptionHandler({UserNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto entityNotFound(BackendException exception) {
        return exception.toErrorDto();
    }
}
