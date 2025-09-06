package ru.hbm.krovotarot.service.random.site.randomorg;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.random.api.RandomOrgClient;
import org.random.api.exception.RandomOrgBaseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import ru.hbm.krovotarot.exception.InternalException;
import ru.hbm.krovotarot.service.random.RandomService;
import ru.hbm.krovotarot.service.random.SimpleRandomService;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
@ConditionalOnProperties({
        @ConditionalOnProperty(name = "random.service.type", havingValue = "site"),
        @ConditionalOnProperty(name = "random.site.selected", havingValue = "random-org")
})
public class RandomOrgRandomService implements RandomService {

    private final SimpleRandomService simpleRandomService;

    @Value("${random.site.random-org.api-key}")
    private String apiKey;

    private RandomOrgClient client;

    @PostConstruct
    private void init() {
        client = RandomOrgClient.getRandomOrgClient(apiKey);
    }

    @Override
    @Retryable(retryFor = {RandomOrgBaseException.class, InternalException.class}, maxAttempts = 5, backoff = @Backoff(delay = 2000))
    public int getRandomInt(int min, int max) {
        try {
            return client.generateIntegers(1, min, max, false)[0];
        } catch (IOException e) {
            throw new InternalException(e);
        }
    }

    @Override
    @Retryable(retryFor = {RandomOrgBaseException.class, InternalException.class}, maxAttempts = 5, backoff = @Backoff(delay = 2000))
    public boolean getRandomBoolean() {
        try {
            int i = client.generateIntegers(1, 0, 1, false)[0];

            return i == 1;
        } catch (IOException e) {
            throw new InternalException(e);
        }
    }

    @Recover
    private int recoverRandomIntAfterRandomOrgBaseException(RandomOrgBaseException ex, int min, int max) {
        return recoverRandomInt(ex, min, max);
    }

    @Recover
    private int recoverRandomIntAfterInternalException(InternalException ex, int min, int max) {
        return recoverRandomInt(ex, min, max);
    }

    @Recover
    private boolean recoverRandomBooleanAfterRandomOrgBaseException(RandomOrgBaseException ex) {
        return recoverRandomBoolean(ex);
    }

    @Recover
    private boolean recoverRandomBooleanAfterInternalException(InternalException ex) {
        return recoverRandomBoolean(ex);
    }

    private int recoverRandomInt(Throwable ex, int min, int max) {
        log.warn("Получено исключение от Random.org когда запрашивали рандомное число, генерируем через SimpleRandom", ex);

        return simpleRandomService.getRandomInt(min, max);
    }

    private boolean recoverRandomBoolean(Throwable ex) {
        log.warn("Получено исключение от Random.org когда запрашивали рандомный булевый флаг, генерируем через SimpleRandom", ex);

        return simpleRandomService.getRandomBoolean();
    }
}
