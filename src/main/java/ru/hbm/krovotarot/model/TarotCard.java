package ru.hbm.krovotarot.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"firstRefCombination", "secondRefCombination", "image"})
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

    @ReadOnlyProperty
    @DocumentReference(lazy = true, lookup = "{ 'card' : ?#{#self._id} }")
    private TarotImage image;

    @ReadOnlyProperty
    @DocumentReference(lazy = true, lookup = "{ 'card' : ?#{#self._id} }")
    private CardCombinationInterpretation firstRefCombination;

    @ReadOnlyProperty
    @DocumentReference(lazy = true, lookup = "{ 'combinationCard' : ?#{#self._id} }")
    private CardCombinationInterpretation secondRefCombination;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CardDescription {
        private String description;
        private String reverseDescription;

        public String descriptionByReversed(boolean isReversed) {
            return isReversed ? reverseDescription : description;
        }
    }
}
