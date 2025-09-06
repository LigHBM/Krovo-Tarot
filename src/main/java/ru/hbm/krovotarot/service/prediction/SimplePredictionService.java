package ru.hbm.krovotarot.service.prediction;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.hbm.krovotarot.Constants;
import ru.hbm.krovotarot.dto.PredictionResultDto;
import ru.hbm.krovotarot.dto.PredictionType;
import ru.hbm.krovotarot.mapper.TarotCardMapper;
import ru.hbm.krovotarot.model.TarotCard;
import ru.hbm.krovotarot.service.TarotCardService;
import ru.hbm.krovotarot.service.random.RandomService;

import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
@ConditionalOnProperty(name = "prediction.type", havingValue = "simple")
public class SimplePredictionService implements PredictionService {

    private final TarotCardService tarotCardService;
    private final RandomService randomService;
    private final TarotCardMapper mapper;

    @Override
    public PredictionResultDto predictByOneCard(@NotNull PredictionType type) {
        Integer sequenceNum = randomService.getRandomInt(1, Constants.SIZE_OF_DECK);
        boolean isReversed = randomService.getRandomBoolean();

        TarotCard card = tarotCardService.getCardBySequenceNumber(sequenceNum);

        String prediction = getPrediction(card, type, isReversed);

        PredictionResultDto predictionResult = new PredictionResultDto();
        predictionResult.setCards(List.of(mapper.mapToTarotCardInfoDto(card, isReversed)));
        predictionResult.setInterpretation(prediction);

        return predictionResult;
    }

    @Override
    public PredictionResultDto predictByThreeCards(@NotNull PredictionType type) {
        return null;
    }

    private String getPrediction(TarotCard card, @NotNull PredictionType type, boolean isReversed) {
        return switch (type) {
            case ALL -> buildFullPrediction(card, isReversed);
            case GENERAL -> card.getGeneralMeaning().descriptionByReversed(isReversed);
            case LOVE -> card.getLoveMeaning().descriptionByReversed(isReversed);
            case QUESTIONS -> card.getQuestionsMeaning().descriptionByReversed(isReversed);
            case DAY -> card.getDayMeaning().descriptionByReversed(isReversed);
        };
    }

    private String buildFullPrediction(TarotCard card, boolean isReversed) {
        StringBuilder sb = new StringBuilder();

        sb.append("Общая интерпретация:\n");
        sb.append(card.getGeneralMeaning().descriptionByReversed(isReversed));
        sb.append("\n\n");

        sb.append("В любовном вопросе:\n");
        sb.append(card.getLoveMeaning().descriptionByReversed(isReversed));
        sb.append("\n\n");

        sb.append("По заданному вопросу:\n");
        sb.append(card.getQuestionsMeaning().descriptionByReversed(isReversed));
        sb.append("\n\n");

        sb.append("Предсказание на день:\n");
        sb.append(card.getDayMeaning().descriptionByReversed(isReversed));
        sb.append("\n\n");

        return sb.toString();
    }
}
