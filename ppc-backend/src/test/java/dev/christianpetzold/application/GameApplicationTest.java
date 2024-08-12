package dev.christianpetzold.application;

import dev.christianpetzold.api.dto.*;
import dev.christianpetzold.repository.PlayerRepository;
import dev.christianpetzold.repository.PlayerSpellRepository;
import dev.christianpetzold.repository.entities.*;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class GameApplicationTest {

    @InjectMock
    PlayerRepository playerRepositoryMock;

    @InjectMock
    PlayerSpellRepository playerSpellRepositoryMock;

    @Inject
    GameApplication gameApplication;

    Country country = Country.builder()
            .id(UUID.fromString("89350b39-3086-4e15-9f83-894f6f468992"))
            .abbreviation("ITA")
            .name("Italy")
            .flagFileName("italy.webp")
            .build();

    Position position = Position.builder()
            .id(UUID.fromString("28c8266d-6cd1-4536-a819-efa84b3004a9"))
            .abbreviation("DEF")
            .name("Defender")
            .build();

    LocalDate birthdate = OffsetDateTime.parse("1968-06-26T00:00:00.000Z").toLocalDate();

    Player player = Player.builder()
            .id(UUID.fromString("b994b7ad-0bee-4b4b-92a1-ee41097cd89e"))
            .firstName("Paolo")
            .lastName("Maldini")
            .nickname(null)
            .birthdate(birthdate)
            .country(country)
            .position(position)
            .fame(5)
            .stillPlaying(false)
            .build();

    Club club = Club.builder()
            .id(UUID.fromString("6964f609-b04a-4ed7-adfb-0e4dbc728785"))
            .name("AC Milan")
            .country(country)
            .build();

    PlayerSpell playerSpell = PlayerSpell.builder()
            .id(UUID.fromString("fe56b4e9-b998-42d8-9e2f-60a4b93c8ddc"))
            .player(player)
            .club(club)
            .arrivalYear(1985)
            .arrivalMonth(7)
            .departureYear(2009)
            .departureMonth(7)
            .build();

    List<PlayerSpell> playerSpells = List.of(playerSpell);

    PositionDTO positionDTO = PositionDTO.builder()
            .name(position.getName())
            .abbreviation(position.getAbbreviation())
            .build();

    CountryDTO countryDTO = CountryDTO.builder()
            .name(country.getName())
            .abbreviation(country.getAbbreviation())
            .flagFileName(country.getFlagFileName())
            .build();

    ClubDTO clubDTO = ClubDTO.builder()
            .name(club.getName())
            .country(countryDTO)
            .build();

    PlayerSpellDTO playerSpellDTO = PlayerSpellDTO.builder()
            .club(clubDTO)
            .arrivalYear(playerSpell.getArrivalYear())
            .arrivalMonth(playerSpell.getArrivalMonth())
            .departureYear(playerSpell.getDepartureYear())
            .departureMonth(playerSpell.getDepartureMonth())
            .build();

    List<PlayerSpellDTO> playerSpellDTOs = List.of(playerSpellDTO);

    GuessPlayerDTO expected = GuessPlayerDTO.builder()
            .playerAge((int) ChronoUnit.YEARS.between(player.getBirthdate(), LocalDate.now()))
            .fame(player.getFame())
            .stillPlaying(player.isStillPlaying())
            .position(positionDTO)
            .country(countryDTO)
            .playerSpells(playerSpellDTOs)
            .build();


    @Test
    void getRandomPlayerGuessingInfo() {
        // Given
        Mockito.when(playerRepositoryMock.findRandom()).thenReturn(player);
        Mockito.when(playerSpellRepositoryMock.findByPlayer(player)).thenReturn(playerSpells);

        // When
        GuessPlayerDTO guessPlayerDTO = gameApplication.getRandomPlayerGuessingInfo();

        // Then
         assertEquals(expected, guessPlayerDTO);
    }
}