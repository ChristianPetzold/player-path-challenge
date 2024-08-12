package dev.christianpetzold.api.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@Value
public class PlayerSpellDTO implements Serializable {
    transient ClubDTO club;
    Integer arrivalYear;
    Integer arrivalMonth;
    Integer departureYear;
    Integer departureMonth;
}
