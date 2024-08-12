package dev.christianpetzold.api.dto;

import lombok.*;

import java.io.Serializable;

@Value
@Builder
public class ClubDTO implements Serializable {
    String name;
    transient CountryDTO country;
}
