package dev.christianpetzold.api.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@Value
public class CountryDTO implements Serializable {
    String abbreviation;
    String name;
    String flagFileName;


}
