package com.heartforecast.common.jwt.exception;

import com.heartforecast.common.exception.security.HeartForecastSecurityException;
import org.springframework.http.HttpStatus;

public class ExpiredTokenException extends HeartForecastSecurityException {

    public ExpiredTokenException() {
        super(HttpStatus.UNAUTHORIZED, "EXPIRED_TOKEN", "만료된 토큰입니다.");
    }
}
