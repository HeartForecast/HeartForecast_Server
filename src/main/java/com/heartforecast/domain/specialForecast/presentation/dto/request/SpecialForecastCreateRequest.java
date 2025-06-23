package com.heartforecast.domain.specialForecast.presentation.dto.request;


public record SpecialForecastCreateRequest(
    Long eventId,
    Long childId,
    Long emotionTypeId,
    String memo
) {}
