package ru.hbm.krovotarot.dto;

import lombok.Data;

@Data
public class TarotCardInfoDto {
    private Long id;
    private String name;
    private String imageUrl;
    private Boolean isReversed;
}
