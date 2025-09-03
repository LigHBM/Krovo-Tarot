package ru.hbm.krovotarot.dto;

import lombok.Data;

import java.util.List;

@Data
public class PredictionResultDto {
    private List<TarotCardInfoDto> cards;
    private String interpretation;
}
