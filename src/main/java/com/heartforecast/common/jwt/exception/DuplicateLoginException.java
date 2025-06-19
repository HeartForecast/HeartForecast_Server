package com.heartforecast.common.jwt.exception;

import com.heartforecast.common.exception.security.HeartForecastSecurityException;
import org.springframework.http.HttpStatus;

public class DuplicateLoginException extends HeartForecastSecurityException {

    public DuplicateLoginException() {
        super(HttpStatus.UNAUTHORIZED, "DUPLICATE_LOGIN", "이미 로그인한 상태입니다.");
    }
}
