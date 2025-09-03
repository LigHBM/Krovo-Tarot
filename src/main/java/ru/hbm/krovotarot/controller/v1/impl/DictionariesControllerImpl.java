package ru.hbm.krovotarot.controller.v1.impl;

import org.springframework.web.bind.annotation.RestController;
import ru.hbm.krovotarot.controller.v1.DictionariesController;
import ru.hbm.krovotarot.dto.PredictionType;

import java.util.Arrays;
import java.util.List;

@RestController
public class DictionariesControllerImpl implements DictionariesController {
    @Override
    public List<String> getPredicateTypes() {
        return Arrays.stream(PredictionType.values())
                .map(Enum::name)
                .toList();
    }
}
