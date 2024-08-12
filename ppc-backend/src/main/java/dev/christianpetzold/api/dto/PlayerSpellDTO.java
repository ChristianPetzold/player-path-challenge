package dev.christianpetzold.api.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@EqualsAndHashCode
@ToString
public class PlayerSpellDTO {
    private ClubDTO club;
    private Integer arrivalYear;
    private Integer arrivalMonth;
    private Integer departureYear;
    private Integer departureMonth;
}
