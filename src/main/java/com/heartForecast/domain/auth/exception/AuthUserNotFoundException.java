package com.heartForecast.domain.auth.exception;

import com.heartForecast.common.exception.security.HeartForecastSecurityException;
import org.springframework.http.HttpStatus;

public class AuthUserNotFoundException extends HeartForecastSecurityException {

    public AuthUserNotFoundException() {
        super(HttpStatus.NOT_FOUND, "USER_NOT_FOUND","유저를 찾을 수 없습니다.");
    }
}
