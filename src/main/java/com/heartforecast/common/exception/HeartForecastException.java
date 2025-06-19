package com.heartforecast.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class HeartForecastException extends RuntimeException {
    private final HttpStatus status;
    private final String errorCode;

    public HeartForecastException(HttpStatus status, String errorCode, String message) {
        super(message);
        this.status = status;
        this.errorCode = errorCode;
    }
}

