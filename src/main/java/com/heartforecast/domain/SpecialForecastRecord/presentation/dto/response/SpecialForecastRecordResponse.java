package com.heartforecast.domain.SpecialForecastRecord.presentation.dto.response;

import com.heartforecast.domain.SpecialForecastRecord.domain.SpecialForecastRecord;

import java.time.LocalDate;

public record SpecialForecastRecordResponse(
    Long id,
    Long specialForecastId,
    Long childId,
    Long emotionTypeId,
    LocalDate date,
    String memo
) {
  public static SpecialForecastRecordResponse from(SpecialForecastRecord specialForecastRecord) {
    return new SpecialForecastRecordResponse(
        specialForecastRecord.getId(),
        specialForecastRecord.getSpecialForecast().getId(),
        specialForecastRecord.getChild().getId(),
        specialForecastRecord.getEmotionType().getId(),
        specialForecastRecord.getDate(),
        specialForecastRecord.getMemo()
    );
  }
}
