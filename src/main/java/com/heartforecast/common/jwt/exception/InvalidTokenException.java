package com.heartforecast.common.jwt.exception;

import com.heartforecast.common.exception.security.HeartForecastSecurityException;
import org.springframework.http.HttpStatus;

public class InvalidTokenException extends HeartForecastSecurityException {

    public InvalidTokenException() {
        super(HttpStatus.UNAUTHORIZED, "INVALID_TOKEN", "잘못된 토큰입니다.");
    }
}
