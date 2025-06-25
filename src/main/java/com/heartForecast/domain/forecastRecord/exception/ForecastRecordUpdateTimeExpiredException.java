package com.heartForecast.domain.forecastRecord.exception;

import com.heartForecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class ForecastRecordUpdateTimeExpiredException extends HeartForecastException {
  public ForecastRecordUpdateTimeExpiredException() {
    super(HttpStatus.FORBIDDEN, "FORECAST_RECORD_UPDATE_TIME_EXPIRED", "예보 기록은 생성 후 24시간 이내에만 수정할 수 있습니다.");
  }
}