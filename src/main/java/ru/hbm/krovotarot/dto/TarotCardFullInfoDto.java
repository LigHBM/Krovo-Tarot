package ru.hbm.krovotarot.dto;

import lombok.Data;
import ru.hbm.krovotarot.model.CardType;

@Data
public class TarotCardFullInfoDto {
    private Long id;
    private String name;
    private Integer sequenceNumber;
    private String generalMeaning;
    private String loveMeaning;
    private String dayMeaning;
    private String generalMeaningReverse;
    private String loveMeaningReverse;
    private String dayMeaningReverse;
    private CardType type;
    private String hint;
    private String imageUrl;
}
