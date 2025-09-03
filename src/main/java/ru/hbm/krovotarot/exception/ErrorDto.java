package ru.hbm.krovotarot.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorDto {
    private final String title;
    private final String message;
    private final LocalDateTime timestamp;
}
