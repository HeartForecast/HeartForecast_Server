package com.heartforecast.common.jwt.exception;

import com.heartforecast.common.exception.security.HeartForecastSecurityException;
import org.springframework.http.HttpStatus;

public class ExpiredRefreshTokenException extends HeartForecastSecurityException {

    public ExpiredRefreshTokenException() {
        super(HttpStatus.UNAUTHORIZED, "EXPIRED_REFRESH_TOKEN", "재로그인 해야 합니다.");
    }
}
