package ru.hbm.krovotarot.controller.v1.impl;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import ru.hbm.krovotarot.controller.v1.TarotController;
import ru.hbm.krovotarot.dto.PredictionResultDto;
import ru.hbm.krovotarot.dto.PredictionType;
import ru.hbm.krovotarot.dto.TarotCardFullInfoDto;
import ru.hbm.krovotarot.dto.TarotCardInfoDto;
import ru.hbm.krovotarot.service.TarotCardService;
import ru.hbm.krovotarot.service.prediction.PredictionService;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
public class TarotControllerImpl implements TarotController {

    private final TarotCardService tarotCardService;
    private final PredictionService predictionService;

    @Override
    public List<TarotCardInfoDto> getAllCards() {
        return tarotCardService.getAllCards();
    }

    @Override
    public TarotCardFullInfoDto getCardById(@NotNull Long id) {
        return tarotCardService.getCardById(id);
    }

    @Override
    public PredictionResultDto predictByOneCard(PredictionType type) {
        if (type == null) {
            type = PredictionType.ALL;
        }

        return predictionService.predictByOneCard(type);
    }

    @Override
    public PredictionResultDto predictByThreeCards(PredictionType type) {
        if (type == null) {
            type = PredictionType.ALL;
        }

        return predictionService.predictByThreeCards(type);
    }
}
