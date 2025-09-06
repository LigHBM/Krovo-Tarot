package ru.hbm.krovotarot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.hbm.krovotarot.model.TarotCard;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface TarotCardRepository extends MongoRepository<TarotCard, Long> {
    Optional<TarotCard> findBySequenceNumber(Integer sequenceNumber);

    List<TarotCard> findAllBySequenceNumberIn(Collection<Integer> sequenceNumbers);
}
