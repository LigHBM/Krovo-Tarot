package ru.hbm.krovotarot.service.prediction;

import ru.hbm.krovotarot.dto.PredictionResultDto;
import ru.hbm.krovotarot.dto.PredictionType;

public interface PredictionService {
    PredictionResultDto predictByOneCard(PredictionType type);

    PredictionResultDto predictByThreeCards(PredictionType type);
}
