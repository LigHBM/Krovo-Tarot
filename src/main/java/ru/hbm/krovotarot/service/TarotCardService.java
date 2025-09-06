package ru.hbm.krovotarot.service;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.hbm.krovotarot.dto.TarotCardFullInfoDto;
import ru.hbm.krovotarot.dto.TarotCardInfoDto;
import ru.hbm.krovotarot.exception.NotFoundException;
import ru.hbm.krovotarot.mapper.TarotCardMapper;
import ru.hbm.krovotarot.model.TarotCard;
import ru.hbm.krovotarot.repository.TarotCardRepository;

import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class TarotCardService {
    private final TarotCardRepository tarotCardRepository;
    private final TarotCardMapper tarotCardMapper;

    public List<TarotCardInfoDto> getAllCards() {
        return tarotCardRepository.findAll().stream()
                .sorted((c1, c2) -> c1.getSequenceNumber().compareTo(c2.getSequenceNumber()))
                .map(c -> tarotCardMapper.mapToTarotCardInfoDto(c, null))
                .toList();
    }

    public TarotCardFullInfoDto getCardById(@NotNull Long id) {
        return tarotCardRepository.findById(id)
                .map(tarotCardMapper::mapToTarotCardFullInfoDto)
                .orElseThrow(() -> new NotFoundException("Не удалось найти карту по ID " + id));
    }

    public TarotCard getCardBySequenceNumber(@NotNull Integer sequenceNumber) {
        return tarotCardRepository.findBySequenceNumber(sequenceNumber)
                .orElseThrow(() -> new NotFoundException("Не удалось найти карту по номеру " + sequenceNumber));
    }
}
