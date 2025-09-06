package ru.hbm.krovotarot.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public abstract class BaseException extends RuntimeException {
    private final HttpStatus status;

    protected BaseException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    protected BaseException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
    }

    protected BaseException(Throwable cause, HttpStatus status) {
        super(cause);
        this.status = status;
    }
}
