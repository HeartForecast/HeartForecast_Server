package com.heartforecast.domain.forecast.presentation.dto.response;

import com.heartforecast.domain.forecast.domain.Forecast;
import com.heartforecast.domain.forecast.domain.value.TimeZone;

import java.time.LocalDate;

public record ForecastResponse(
    Long id,
    Long childId,
    Long emotionTypeId,
    LocalDate date,
    TimeZone timeZone,
    String memo
) {
  public static ForecastResponse from(Forecast forecast) {
    return new ForecastResponse(
        forecast.getId(),
        forecast.getChild().getId(),
        forecast.getEmotionType().getId(),
        forecast.getDate(),
        forecast.getTimeZone(),
        forecast.getMemo()
    );
  }
}
