package ru.hbm.krovotarot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tarot_cards")
public class TarotCard {
    @Id
    private Long id;
    private String name;
    private Integer sequenceNumber;
    private CardDescription generalMeaning;
    private CardDescription loveMeaning;
    private CardDescription questionsMeaning;
    private CardDescription dayMeaning;
    private CardType type;
    private String hint;
    private TarotImage image;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CardDescription {
        private String description;
        private String reverseDescription;
    }
}
