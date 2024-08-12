package dev.christianpetzold.api.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CountryDTO {
    private String abbreviation;
    private String name;
    private String flagFileName;


}
