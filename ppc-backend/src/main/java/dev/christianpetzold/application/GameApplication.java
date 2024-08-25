package dev.christianpetzold.application;

import dev.christianpetzold.api.dto.*;
import dev.christianpetzold.repository.PlayerRepository;
import dev.christianpetzold.repository.PlayerSpellRepository;
import dev.christianpetzold.repository.entities.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class GameApplication {

    private final @NonNull PlayerRepository playerRepository;
    private final @NonNull PlayerSpellRepository playerSpellRepository;

    public GuessPlayerDTO getRandomPlayerGuessingInfo() {
        Player randomPlayer = playerRepository.findRandom();

        if (null == randomPlayer) {
            throw new WebApplicationException(
                    ErrorMessages.NO_PLAYER_FOUND.toString(),
                    Response.Status.INTERNAL_SERVER_ERROR
            );
        }

        List<PlayerSpell> playerSpells = playerSpellRepository.findByPlayer(randomPlayer);

        if (playerSpells.isEmpty()) {
            throw new WebApplicationException(
                    ErrorMessages.INTERNAL_ERROR.toString(),
                    Response.Status.INTERNAL_SERVER_ERROR
            );
        }

        return mapToGuessPlayerDTO(randomPlayer, playerSpells);
    }

    private GuessPlayerDTO mapToGuessPlayerDTO(Player player, List<PlayerSpell> playerSpells) {
        return GuessPlayerDTO.builder()
                .playerAge(calculateAge(player.getBirthdate()))
                .fame(player.getFame())
                .stillPlaying(player.isStillPlaying())
                .position(mapToPositionDTO(player.getPosition()))
                .country(mapToCountryDTO(player.getCountry()))
                .playerSpells(mapToPlayerSpellDTO(playerSpells))
                .build();
    }

    private int calculateAge(LocalDate birthdate) {
        return (int) ChronoUnit.YEARS.between(birthdate, LocalDate.now());
    }

    private PositionDTO mapToPositionDTO(Position position) {
        return PositionDTO.builder()
                .name(position.getName())
                .abbreviation(position.getAbbreviation())
                .build();
    }

    private CountryDTO mapToCountryDTO(Country country) {
        return CountryDTO.builder()
                .abbreviation(country.getAbbreviation())
                .name(country.getName())
                .flagFileName(country.getFlagFileName())
                .build();
    }

    private List<PlayerSpellDTO> mapToPlayerSpellDTO(List<PlayerSpell> playerSpells) {
        return playerSpells.stream().map(spell -> PlayerSpellDTO.builder()
                        .club(mapToClubDTO(spell.getClub()))
                        .arrivalYear(spell.getArrivalYear())
                        .arrivalMonth(spell.getArrivalMonth())
                        .departureYear(spell.getDepartureYear())
                        .departureMonth(spell.getDepartureMonth())
                        .build())
                .toList();
    }

    private ClubDTO mapToClubDTO(Club club) {
        return ClubDTO.builder()
                .name(club.getName())
                .country(mapToCountryDTO(club.getCountry()))
                .build();
    }

}
