package ru.hbm.krovotarot.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "сard_combination_interpretations")
public class CardCombinationInterpretation {
    @Id
    private Long id;
    private String interpretation; // Толкование комбинации карт

    @DocumentReference(lazy=true)
    private TarotCard card;

    @DocumentReference(lazy=true)
    private TarotCard combinationCard;
}
