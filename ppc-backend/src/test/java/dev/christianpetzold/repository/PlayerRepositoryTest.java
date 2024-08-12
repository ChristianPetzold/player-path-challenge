package dev.christianpetzold.repository;

import dev.christianpetzold.repository.entities.Player;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class PlayerRepositoryTest {

    @Inject
    PlayerRepository playerRepository;

    @Test
    @TestTransaction
    void findRandomTest() {
        // Given
        List<Player> players = playerRepository.listAll();

        // When
        Player randomPlayer = playerRepository.findRandom();

        // Then
        assertTrue(players.contains(randomPlayer));
    }
}