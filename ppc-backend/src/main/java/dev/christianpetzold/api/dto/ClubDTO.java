package dev.christianpetzold.api.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ClubDTO {
    private String name;
    private CountryDTO country;
}
