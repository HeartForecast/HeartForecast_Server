package com.heartForecast.domain.specialForecast.exception;

import com.heartForecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class SpecialForecastNotFoundException extends HeartForecastException {
  public SpecialForecastNotFoundException() {
    super(HttpStatus.NOT_FOUND, "SPECIAL_FORECAST_NOT_FOUND", "특보를 찾을 수 없습니다.");
  }
}
