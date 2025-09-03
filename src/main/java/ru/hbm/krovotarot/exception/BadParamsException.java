package ru.hbm.krovotarot.exception;

import org.springframework.http.HttpStatus;

public class BadParamsException extends BaseException {

    public BadParamsException() {
        super(HttpStatus.BAD_REQUEST);
    }

    public BadParamsException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }

    public BadParamsException(String message, Throwable cause) {
        super(message, cause, HttpStatus.BAD_REQUEST);
    }

    public BadParamsException(Throwable cause) {
        super(cause, HttpStatus.BAD_REQUEST);
    }
}
