package ru.hbm.krovotarot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.validator.constraints.Range;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tarot_cards")
public class TarotCard {
    @Id
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true, length = 30)
    private String name;

    @NotNull
    @Range(min = 1, max = 78)
    @Column(nullable = false, unique = true)
    private Integer sequenceNumber;

    @Column(unique = true)
    private String hint;

    @Column(nullable = false, length = 5)
    @Enumerated(EnumType.STRING)
    private CardType type;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private CardDescription generalMeaning;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private CardDescription loveMeaning;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private CardDescription dayMeaning;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "image_id", nullable = false, unique = true)
    private TarotImage image;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "card")
    private List<CardCombinationInterpretation> firstRefCombination;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "combinationCard")
    private List<CardCombinationInterpretation> secondRefCombination;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        TarotCard card = (TarotCard) o;
        return getId() != null && Objects.equals(getId(), card.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
