package ru.hbm.krovotarot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "сard_combination_interpretations")
public class CardCombinationInterpretation {
    @Id
    private Long id;

    @NotBlank
    @Column(name = "interpretation", nullable = false, length = 1024)
    private String interpretation; // Толкование комбинации карт

    @ManyToOne
    @JoinColumn(name= "first_card_id", nullable = false, updatable = false)
    private TarotCard card;

    @ManyToOne
    @JoinColumn(name = "second_card_id", nullable = false, updatable = false)
    private TarotCard combinationCard;
}
