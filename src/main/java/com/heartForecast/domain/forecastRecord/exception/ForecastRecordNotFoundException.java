package com.heartForecast.domain.forecastRecord.exception;

import com.heartForecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class ForecastRecordNotFoundException extends HeartForecastException {
  public ForecastRecordNotFoundException() {
    super(HttpStatus.NOT_FOUND, "FORECAST_RECORD_NOT_FOUND", "예보 기록을 찾을 수 없습니다.");
  }
}
