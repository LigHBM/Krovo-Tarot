package ru.hbm.krovotarot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.hbm.krovotarot.dto.TarotCardFullInfoDto;
import ru.hbm.krovotarot.dto.TarotCardInfoDto;
import ru.hbm.krovotarot.model.TarotCard;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarotCardMapper {
    @Mapping(target = "id", source = "tarotCard.id")
    @Mapping(target = "name", source = "tarotCard.name")
    @Mapping(target = "imageUrl", source = "tarotCard.image.url")
    @Mapping(target = "isReversed", source = "isReversed")
    TarotCardInfoDto mapToTarotCardInfoDto(TarotCard tarotCard, Boolean isReversed);

    @Mapping(target = "id", source = "tarotCard.id")
    @Mapping(target = "name", source = "tarotCard.name")
    @Mapping(target = "sequenceNumber", source = "tarotCard.sequenceNumber")
    @Mapping(target = "generalMeaning", source = "tarotCard.generalMeaning.description")
    @Mapping(target = "loveMeaning", source = "tarotCard.loveMeaning.description")
    @Mapping(target = "dayMeaning", source = "tarotCard.dayMeaning.description")
    @Mapping(target = "generalMeaningReverse", source = "tarotCard.generalMeaning.reverseDescription")
    @Mapping(target = "loveMeaningReverse", source = "tarotCard.generalMeaning.reverseDescription")
    @Mapping(target = "dayMeaningReverse", source = "tarotCard.dayMeaning.reverseDescription")
    @Mapping(target = "type", source = "tarotCard.type")
    @Mapping(target = "hint", source = "tarotCard.hint")
    @Mapping(target = "imageUrl", source = "tarotCard.image.url")
    TarotCardFullInfoDto mapToTarotCardFullInfoDto(TarotCard tarotCard);

    List<TarotCardFullInfoDto> mapListToTarotCardFullInfoDto(List<TarotCard> tarotCard);
}
