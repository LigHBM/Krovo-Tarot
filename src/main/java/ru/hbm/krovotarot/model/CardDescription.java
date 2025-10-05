package ru.hbm.krovotarot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "card_descriptions")
public class CardDescription {
    @Id
    private Long id;

    @NotNull
    @Column(length = 1024)
    private String description;

    @Column(length = 1024)
    private String reverseDescription;

    public String descriptionByReversed(boolean isReversed) {
        return isReversed ? reverseDescription : description;
    }
}
