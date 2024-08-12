package dev.christianpetzold.api.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@Value
public class ErrorDTO implements Serializable {
    String errorCode;
    String message;
}
