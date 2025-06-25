package com.heartForecast.domain.specialForecastRecord.exception;

import com.heartForecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class SpecialForecastRecordNotFoundException extends HeartForecastException {
  public SpecialForecastRecordNotFoundException() {
    super(HttpStatus.NOT_FOUND, "SPECIAL_FORECAST_RECORD_NOT_FOUND", "특보 기록을 찾을 수 없습니다.");
  }
}
