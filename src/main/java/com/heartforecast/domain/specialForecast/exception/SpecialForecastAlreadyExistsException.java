package com.heartforecast.domain.specialForecast.exception;

import com.heartforecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class SpecialForecastAlreadyExistsException extends HeartForecastException {
  public SpecialForecastAlreadyExistsException() {
    super(HttpStatus.CONFLICT, "SPECIAL_FORECAST_ALREADY_EXISTS", "해당 이벤트로 생성된 특보가 이미 존재합니다.");
  }
}
