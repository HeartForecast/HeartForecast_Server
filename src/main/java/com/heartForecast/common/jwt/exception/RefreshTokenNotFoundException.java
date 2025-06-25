package com.heartForecast.common.jwt.exception;

import com.heartForecast.common.exception.security.HeartForecastSecurityException;
import org.springframework.http.HttpStatus;

public class RefreshTokenNotFoundException extends HeartForecastSecurityException {

    public RefreshTokenNotFoundException() {
        super(HttpStatus.UNAUTHORIZED, "REFRESH_TOKEN_NOT_FOUND", "리프레시 토큰이 존재하지 않습니다.");
    }
}
