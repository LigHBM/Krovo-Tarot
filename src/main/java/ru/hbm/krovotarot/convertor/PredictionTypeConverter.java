package ru.hbm.krovotarot.convertor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ru.hbm.krovotarot.dto.PredictionType;
import ru.hbm.krovotarot.exception.BadParamsException;

@Slf4j
@Component
public class PredictionTypeConverter implements Converter<String, PredictionType> {
    @Override
    public PredictionType convert(String type) {
        try {
            if (!StringUtils.hasLength(type)) {
                return null;
            }

            return PredictionType.valueOf(type.toUpperCase());
        } catch (Exception e) {
            log.error("Не удалось получить тип предсказания по парметру {}", type, e);
            throw new BadParamsException(String.format("Неизвестный тип предсказания: %s", type));
        }
    }
}
