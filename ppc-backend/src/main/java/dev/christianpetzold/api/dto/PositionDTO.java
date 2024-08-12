package dev.christianpetzold.api.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@Value
public class PositionDTO implements Serializable {
    String name;
    String abbreviation;
}
