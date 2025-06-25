package com.heartforecast.domain.heartShare.exception;

import com.heartforecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class HeartShareNotFoundException extends HeartForecastException {
  public HeartShareNotFoundException() {
    super(HttpStatus.NOT_FOUND, "HEART_SHARE_NOT_FOUND", "마음공유를 찾을 수 없습니다.");
  }
}
