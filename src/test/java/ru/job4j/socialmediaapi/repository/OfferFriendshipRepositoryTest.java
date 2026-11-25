package ru.job4j.socialmediaapi.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.liquibase.autoconfigure.LiquibaseAutoConfiguration;
import ru.job4j.socialmediaapi.domain.OfferFriendshipStatus;
import ru.job4j.socialmediaapi.support.PostgreSqlIntegrationTest;

import java.time.Instant;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ImportAutoConfiguration(LiquibaseAutoConfiguration.class)
class OfferFriendshipRepositoryTest extends PostgreSqlIntegrationTest {
    @Autowired
    private OfferFriendshipRepository repository;

    @Test
    @DisplayName("Создание предложения дружбы сохраняет участников, статус и время")
    void whenInsertOfferThenJpaReadsStoredData() {
        var id = UUID.randomUUID();
        var fromUserId = UUID.randomUUID();
        var toUserId = UUID.randomUUID();
        var now = Instant.parse("2026-09-22T10:15:00Z");

        var expected = new OfferFriendshipEntity(
                id, fromUserId, toUserId, OfferFriendshipStatus.PENDING, now, now
        );

        assertThat(repository.create(id, fromUserId, toUserId, now)).isEqualTo(1);

        var stored = repository.findById(id).orElseThrow();
        assertThat(stored).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    @DisplayName("Повторное предложение для той же пары сохраняет первую запись")
    void whenInsertDuplicateThenOriginalOfferRemains() {
        var firstId = UUID.randomUUID();
        var secondId = UUID.randomUUID();
        var fromUserId = UUID.randomUUID();
        var toUserId = UUID.randomUUID();
        var now = Instant.parse("2026-09-22T10:15:00Z");

        var expected = new OfferFriendshipEntity(
                firstId, fromUserId, toUserId, OfferFriendshipStatus.PENDING, now, now
        );

        assertThat(repository.create(firstId, fromUserId, toUserId, now)).isEqualTo(1);
        assertThat(repository.create(secondId, fromUserId, toUserId, now.plusSeconds(1))).isZero();
        var stored = repository.findByFromUserIdAndToUserId(fromUserId, toUserId).orElseThrow();
        assertThat(stored).usingRecursiveComparison().isEqualTo(expected);
        assertThat(repository.findById(secondId)).isEmpty();
    }
}
