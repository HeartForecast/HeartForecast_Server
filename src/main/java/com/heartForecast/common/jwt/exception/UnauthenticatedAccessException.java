package com.heartForecast.common.jwt.exception;

import com.heartForecast.common.exception.security.HeartForecastSecurityException;
import org.springframework.http.HttpStatus;

public class UnauthenticatedAccessException extends HeartForecastSecurityException {
    public UnauthenticatedAccessException() {
        super(HttpStatus.UNAUTHORIZED, "UNAUTHENTICATED_ACCESS", "인증이 필요합니다.");
    }
}
