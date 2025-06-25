package com.heartForecast.domain.heartShare.exception;

import com.heartForecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class HeartShareAccessDeniedException extends HeartForecastException {
  public HeartShareAccessDeniedException() {
    super(HttpStatus.FORBIDDEN, "HEART_SHARE_ACCESS_DENIED", "해당 마음공유에 접근 권한이 없습니다.");
  }
}
