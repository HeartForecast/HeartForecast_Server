package com.heartforecast.domain.user.exception;

import com.heartforecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends HeartForecastException {

  public UserNotFoundException() {
    super(HttpStatus.NOT_FOUND, "USER_NOT_FOUND","유저를 찾을 수 없습니다.");
  }
}
