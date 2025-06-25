package com.heartForecast.domain.user.exception;

import com.heartForecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class UserExistedException extends HeartForecastException {

  public UserExistedException() {
    super(HttpStatus.CONFLICT, "USER_EXISTED", "유저가 이미 존재합니다.");
  }
}
