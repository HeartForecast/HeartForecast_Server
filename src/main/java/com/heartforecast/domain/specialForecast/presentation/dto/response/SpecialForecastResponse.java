package com.heartforecast.domain.specialForecast.presentation.dto.response;

import com.heartforecast.domain.specialForecast.domain.SpecialForecast;

public record SpecialForecastResponse(
    Long id,
    Long eventId,
    Long childId,
    Long emotionTypeId,
    String memo
) {
  public static SpecialForecastResponse from(SpecialForecast specialForecast) {
    return new SpecialForecastResponse(
        specialForecast.getId(),
        specialForecast.getEvent().getId(),
        specialForecast.getChild().getId(),
        specialForecast.getEmotionType().getId(),
        specialForecast.getMemo()
    );
  }
}
