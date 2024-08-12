package dev.christianpetzold.api.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PlayerSpellDTO {
    private ClubDTO club;
    private Integer arrivalYear;
    private Integer arrivalMonth;
    private Integer departureYear;
    private Integer departureMonth;
}
