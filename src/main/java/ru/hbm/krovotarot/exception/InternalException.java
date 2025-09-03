package ru.hbm.krovotarot.exception;

import org.springframework.http.HttpStatus;

public class InternalException extends BaseException {
    public InternalException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public InternalException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public InternalException(String message, Throwable cause) {
        super(message, cause, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public InternalException(Throwable cause) {
        super(cause, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
