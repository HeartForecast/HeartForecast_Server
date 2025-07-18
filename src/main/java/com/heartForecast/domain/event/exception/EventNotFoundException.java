package com.heartForecast.domain.event.exception;

import com.heartForecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class EventNotFoundException extends HeartForecastException {
  public EventNotFoundException() {
    super(HttpStatus.NOT_FOUND, "EVENT_NOT_FOUND", "이벤트를 찾을 수 없습니다.");
  }
}
