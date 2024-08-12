package dev.christianpetzold.api.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Builder
@Value
public class GuessPlayerDTO implements Serializable {
    int playerAge;
    int fame;
    boolean stillPlaying;
    transient PositionDTO position;
    transient CountryDTO country;
    transient List<PlayerSpellDTO> playerSpells;
}
