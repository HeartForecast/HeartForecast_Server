package com.heartforecast.domain.forecastRecord.presentation.dto.response;

import com.heartforecast.domain.forecastRecord.domain.value.TimeZone;
import com.heartforecast.domain.forecastRecord.domain.ForecastRecord;

import java.time.LocalDate;

public record ForecastRecordResponse(
    Long id,
    Long forecastId,
    Long childId,
    Long emotionTypeId,
    LocalDate date,
    TimeZone timeZone,
    String memo
) {
  public static ForecastRecordResponse from(ForecastRecord forecastRecord) {
    return new ForecastRecordResponse(
        forecastRecord.getId(),
        forecastRecord.getForecast().getId(),
        forecastRecord.getChild().getId(),
        forecastRecord.getEmotionType().getId(),
        forecastRecord.getDate(),
        forecastRecord.getTimeZone(),
        forecastRecord.getMemo()
    );
  }
}
