package com.heartforecast.common.jwt.exception;

import com.heartforecast.common.exception.security.HeartForecastSecurityException;
import org.springframework.http.HttpStatus;

public class CustomAccessDeniedException extends HeartForecastSecurityException {
    public CustomAccessDeniedException() {
        super(HttpStatus.FORBIDDEN, "ACCESS_DENIED", "권한이 필요합니다.");
    }
}
