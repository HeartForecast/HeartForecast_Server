package com.heartforecast.domain.SpecialForecastRecord.presentation.dto.response;

import com.heartforecast.domain.SpecialForecastRecord.domain.SpecialForecastRecord;

public record SpecialForecastRecordResponse(
    Long id,
    Long specialForecastId,
    Long childId,
    Long emotionTypeId,
    String memo
) {
  public static SpecialForecastRecordResponse from(SpecialForecastRecord specialForecastRecord) {
    return new SpecialForecastRecordResponse(
        specialForecastRecord.getId(),
        specialForecastRecord.getSpecialForecast().getId(),
        specialForecastRecord.getChild().getId(),
        specialForecastRecord.getEmotionType().getId(),
        specialForecastRecord.getMemo()
    );
  }
}
