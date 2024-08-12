package dev.christianpetzold.api.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class GuessPlayerDTO {
    int playerAge;
    int fame;
    boolean stillPlaying;
    PositionDTO position;
    CountryDTO country;
    List<PlayerSpellDTO> playerSpells;
}
