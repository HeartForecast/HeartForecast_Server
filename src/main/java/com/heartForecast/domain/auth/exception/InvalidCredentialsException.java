package com.heartForecast.domain.auth.exception;

import com.heartForecast.common.exception.security.HeartForecastSecurityException;
import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends HeartForecastSecurityException {

    public InvalidCredentialsException() {
        super(HttpStatus.UNAUTHORIZED, "INVALID_CREDENTIALS", "잘못된 이메일 또는 비밀번호입니다.");
    }
}
