package ru.solonchev.phonecontact.exception;

import org.springframework.http.HttpStatus;
import ru.solonchev.phonecontact.dto.response.ErrorDto;

public interface BackendException {
    default String code() {
        return String.valueOf(HttpStatus.NOT_FOUND.value());
    }

    default String message() {
        return "Not found exception";
    }

    default ErrorDto toErrorDto() {
        return new ErrorDto(code(), message());
    }
}
