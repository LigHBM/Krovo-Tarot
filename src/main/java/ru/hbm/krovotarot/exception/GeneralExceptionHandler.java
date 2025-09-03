package ru.hbm.krovotarot.exception;

import jakarta.validation.ValidationException;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.hbm.krovotarot.Constants;

import java.time.LocalDateTime;

@Slf4j
@Validated
@RestControllerAdvice
public class GeneralExceptionHandler {

    @Value("${spring.profiles.active}")
    private String profile;

    private ErrorDto buildErrorDto(@NotNull Constants.ErrorMessages errorMessage, Exception e) {
        var builder = ErrorDto.builder();

        builder.title(errorMessage.getTitle());
        builder.timestamp(LocalDateTime.now());
        builder.message(Constants.Profiles.DEV.name().equalsIgnoreCase(profile)
                ? e.getMessage() : errorMessage.getMessage());

        return builder.build();
    }

    @ExceptionHandler(BadParamsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleBadParamException(BadParamsException e) {
        return buildErrorDto(Constants.ErrorMessages.BAD_REQUEST, e);
    }

    @ExceptionHandler(InternalException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleInternalException(InternalException e) {
        return buildErrorDto(Constants.ErrorMessages.INTERNAL_SERVER_ERROR, e);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleNotFoundException(NotFoundException e) {
        return buildErrorDto(Constants.ErrorMessages.NOT_FOUND, e);
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleValidationException(ValidationException e) {
        log.error("Перехват ошибки валидации", e);

        return buildErrorDto(Constants.ErrorMessages.BAD_REQUEST, e);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleException(Exception e) {
        log.error("Перехват исключения вне бизнес-логики", e);

        return buildErrorDto(Constants.ErrorMessages.INTERNAL_SERVER_ERROR, e);
    }
}
