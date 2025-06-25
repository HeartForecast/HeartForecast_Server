package com.heartForecast.domain.forecastRecord.exception;

import com.heartForecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class ForecastRecordAlreadyExistsException extends HeartForecastException {
  public ForecastRecordAlreadyExistsException() {
    super(HttpStatus.CONFLICT, "FORECAST_RECORD_ALREADY_EXISTS", "해당 예보로 생성된 예보 기록이 이미 존재합니다.");
  }
}
