package ru.hbm.krovotarot.error;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorDto {
    private final String title;
    private final String message;
    private final LocalDateTime timestamp;
}
