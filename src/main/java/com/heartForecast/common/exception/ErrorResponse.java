package com.heartForecast.common.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        int status,
        String errorCode,
        String message,
        LocalDateTime timestamp
) {
    public static ErrorResponse from(HeartForecastException errorCode) {
        return new ErrorResponse(
                errorCode.getStatus().value(),
                errorCode.getErrorCode(),
                errorCode.getMessage(),
                LocalDateTime.now()
        );
    }

    public static ErrorResponse from(int status, String errorCode, String message) {
        return new ErrorResponse(
                status,
                errorCode,
                message,
                LocalDateTime.now()
        );
    }
}
