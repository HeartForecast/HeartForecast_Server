package com.heartForecast.domain.user.exception;

import com.heartForecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends HeartForecastException {

  public UserNotFoundException() {
    super(HttpStatus.NOT_FOUND, "USER_NOT_FOUND","유저를 찾을 수 없습니다.");
  }
}
