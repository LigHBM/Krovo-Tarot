package ru.hbm.krovotarot.service.random;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.hbm.krovotarot.exception.InternalException;
import ru.hbm.krovotarot.properties.SimpleRandomProperties;

import java.nio.charset.StandardCharsets;
import java.security.DrbgParameters;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;

import static java.security.DrbgParameters.Capability.PR_AND_RESEED;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleRandomService implements RandomService {

    private final SimpleRandomProperties properties;

    private SecureRandom secureRandom;

    @PostConstruct
    private void init() {
        try {
            for (var property : properties.getProperties()) {
                Security.setProperty(property.getName(), property.getValue());
            }

            secureRandom = SecureRandom.getInstance(
                    properties.getAlgorithm(),
                    DrbgParameters.instantiation(properties.getStrength() == null ? 256 : properties.getStrength(),
                            PR_AND_RESEED,
                            properties.getPersonalizationString().getBytes(StandardCharsets.UTF_8))
            );
        } catch (NoSuchAlgorithmException e) {
            log.error("Ошибка при создании SecureRandom", e);
            throw new InternalException(e);
        }
    }

    @Override
    public int getRandomInt(int min, int max) {
        return secureRandom.nextInt(max - min + 1);
    }

    @Override
    public boolean getRandomBoolean() {
        return secureRandom.nextBoolean();
    }
}
