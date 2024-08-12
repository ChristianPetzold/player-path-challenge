package dev.christianpetzold.api.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
@ToString
public class GuessPlayerDTO {
    int playerAge;
    int fame;
    boolean stillPlaying;
    PositionDTO position;
    CountryDTO country;
    List<PlayerSpellDTO> playerSpells;
}
