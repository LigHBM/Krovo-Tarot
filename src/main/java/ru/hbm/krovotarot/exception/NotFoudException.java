package ru.hbm.krovotarot.exception;

import org.springframework.http.HttpStatus;

public class NotFoudException extends BaseException {
    public NotFoudException(HttpStatus status) {
        super(HttpStatus.NOT_FOUND);
    }

    public NotFoudException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }

    public NotFoudException(String message, Throwable cause) {
        super(message, cause, HttpStatus.NOT_FOUND);
    }

    public NotFoudException(Throwable cause) {
        super(cause, HttpStatus.NOT_FOUND);
    }
}
