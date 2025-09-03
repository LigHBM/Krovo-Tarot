package ru.hbm.krovotarot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.hbm.krovotarot.dto.TarotCardFullInfoDto;
import ru.hbm.krovotarot.dto.TarotCardInfoDto;
import ru.hbm.krovotarot.model.TarotCard;

@Mapper(componentModel = "spring")
public interface TarotCardMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "imageUrl", source = "image.url")
    @Mapping(target = "isReversed", source = "isReversed")
    TarotCardInfoDto mapToTarotCardInfoDto(TarotCard tarotCard, Boolean isReversed);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "sequenceNumber", source = "sequenceNumber")
    @Mapping(target = "generalMeaning", source = "generalMeaning.description")
    @Mapping(target = "loveMeaning", source = "loveMeaning.description")
    @Mapping(target = "questionsMeaning", source = "questionsMeaning.description")
    @Mapping(target = "dayMeaning", source = "dayMeaning.description")
    @Mapping(target = "generalMeaningReverse", source = "generalMeaning.reverseDescription")
    @Mapping(target = "loveMeaningReverse", source = "generalMeaning.reverseDescription")
    @Mapping(target = "questionsMeaningReverse", source = "questionsMeaning.reverseDescription")
    @Mapping(target = "dayMeaningReverse", source = "dayMeaning.reverseDescription")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "hint", source = "hint")
    @Mapping(target = "imageUrl", source = "image.url")
    TarotCardFullInfoDto mapToTarotCardFullInfoDto(TarotCard tarotCard);
}
