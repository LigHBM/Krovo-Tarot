package ru.hbm.krovotarot;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Constants {
    public static final Integer SIZE_OF_DECK = 78;

    public enum Profiles {
        DEV, PROD;
    }

    @Getter
    @RequiredArgsConstructor
    public enum ErrorMessages {
        BAD_REQUEST("Не верные параметры запроса", "Скорректируйте параметры и повторите запрос"),
        INTERNAL_SERVER_ERROR("Внутренняя ошибка сервера", "Повторите запрос позже или обратитесь к администратору"),
        NOT_FOUND("Ресурс не найден",  "Скорректируйте параметры и повторите запрос");

        private final String title;
        private final String message;
    }
}
