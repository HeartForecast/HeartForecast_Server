package com.heartForecast.domain.oauth.exception;

import com.heartForecast.common.exception.security.HeartForecastSecurityException;
import org.springframework.http.HttpStatus;

public class SocialUserExistedException extends HeartForecastSecurityException {
    public SocialUserExistedException() {
        super(HttpStatus.CONFLICT, "USER_EXISTED", "유저가 이미 존재합니다.");
    }
}
