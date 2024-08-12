package dev.christianpetzold.api.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@EqualsAndHashCode
@ToString
public class ClubDTO {
    private String name;
    private CountryDTO country;
}
