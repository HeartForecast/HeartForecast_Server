package com.heartforecast.domain.forecast.exception;

import com.heartforecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class ForecastAlreadyExistsException extends HeartForecastException {
  public ForecastAlreadyExistsException() {
    super(HttpStatus.CONFLICT, "FORECAST_ALREADY_EXISTS", "해당 날짜·시간대 예보가 이미 존재합니다.");
  }
}
