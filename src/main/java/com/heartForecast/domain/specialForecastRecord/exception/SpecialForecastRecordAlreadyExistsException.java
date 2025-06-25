package com.heartForecast.domain.specialForecastRecord.exception;

import com.heartForecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class SpecialForecastRecordAlreadyExistsException extends HeartForecastException {
  public SpecialForecastRecordAlreadyExistsException() {
    super(HttpStatus.CONFLICT, "SPECIAL_FORECAST_RECORD_ALREADY_EXISTS", "해당 특보로 생성된 특보 기록이 이미 존재합니다.");
  }
}
