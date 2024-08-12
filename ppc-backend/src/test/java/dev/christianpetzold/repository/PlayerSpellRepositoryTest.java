package dev.christianpetzold.repository;

import dev.christianpetzold.repository.entities.Player;
import dev.christianpetzold.repository.entities.PlayerSpell;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class PlayerSpellRepositoryTest {

    @Inject
    PlayerSpellRepository playerSpellRepository;

    @Inject
    PlayerRepository playerRepository;

    @Test
    @TestTransaction
    void findByPlayer() {
        // Given
        Player player = playerRepository.findById(
                UUID.fromString("c2febd93-eea8-4c70-8995-85019fbaa377"));
        String[] playerSpellIds = {
                "35d10eba-e4e2-4677-bf59-98011114d10b",
                "6d45cad1-16c2-4176-bfe8-fc613e410dc7",
                "6664ece4-1b65-4437-b3ae-31cf0eb0aeb5"};

        List<PlayerSpell> expectedPlayerSpells = new ArrayList<>();
        for (String playerSpellId : playerSpellIds) {
            expectedPlayerSpells.add(playerSpellRepository.findById(UUID.fromString(playerSpellId)));
        }

        // When
        List<PlayerSpell> playerSpells = playerSpellRepository.findByPlayer(player);

        // Then
        assertTrue(playerSpells.containsAll(expectedPlayerSpells));
        assertEquals(expectedPlayerSpells.size(), playerSpells.size());
    }
}