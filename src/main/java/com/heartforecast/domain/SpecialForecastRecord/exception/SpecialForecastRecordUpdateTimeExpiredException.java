package com.heartforecast.domain.SpecialForecastRecord.exception;

import com.heartforecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class SpecialForecastRecordUpdateTimeExpiredException extends HeartForecastException {
  public SpecialForecastRecordUpdateTimeExpiredException() {
    super(HttpStatus.FORBIDDEN, "SPECIAL_FORECAST_RECORD_UPDATE_TIME_EXPIRED", "특보 기록은 생성 후 24시간 이내에만 수정할 수 있습니다.");
  }
}