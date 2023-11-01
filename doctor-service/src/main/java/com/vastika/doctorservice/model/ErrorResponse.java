package com.vastika.doctorservice.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ErrorResponse {
    private String status;
    private String message;
    private LocalDateTime localDateTime;
}
