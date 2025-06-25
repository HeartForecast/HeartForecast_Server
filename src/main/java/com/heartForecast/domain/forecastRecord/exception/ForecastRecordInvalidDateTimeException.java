package com.heartForecast.domain.forecastRecord.exception;

import com.heartForecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class ForecastRecordInvalidDateTimeException extends HeartForecastException {
  public ForecastRecordInvalidDateTimeException() {
    super(HttpStatus.CONFLICT, "FORECAST_RECORD_INVALID_DATE_TIME", "예보 기록은 원래 예보의 날짜와 시간대가 동일해야 합니다.");
  }
}
