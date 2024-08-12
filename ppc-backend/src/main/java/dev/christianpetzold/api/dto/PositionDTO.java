package dev.christianpetzold.api.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PositionDTO {
    private String name;
    private String abbreviation;
}
