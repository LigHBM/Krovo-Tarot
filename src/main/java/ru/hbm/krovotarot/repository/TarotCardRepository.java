package ru.hbm.krovotarot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.hbm.krovotarot.model.TarotCard;

@Repository
public interface TarotCardRepository extends MongoRepository<TarotCard, Long> {
}
