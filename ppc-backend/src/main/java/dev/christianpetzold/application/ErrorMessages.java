package dev.christianpetzold.application;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum ErrorMessages {
    NO_PLAYER_FOUND("No player was found."),
    INTERNAL_ERROR("Oops something went wrong. Please try again.");

    private final String message;
}
