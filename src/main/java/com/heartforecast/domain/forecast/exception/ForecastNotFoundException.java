package com.heartforecast.domain.forecast.exception;

import com.heartforecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class ForecastNotFoundException extends HeartForecastException {
  public ForecastNotFoundException() {
    super(HttpStatus.NOT_FOUND, "FORECAST_NOT_FOUND", "예보를 찾을 수 없습니다.");
  }
}
