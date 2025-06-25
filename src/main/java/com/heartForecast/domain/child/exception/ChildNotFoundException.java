package com.heartForecast.domain.child.exception;

import com.heartForecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class ChildNotFoundException extends HeartForecastException {
  public ChildNotFoundException() {
    super(HttpStatus.NOT_FOUND, "CHILD_NOT_FOUND","아이를 찾을 수 없습니다.");
  }
}
