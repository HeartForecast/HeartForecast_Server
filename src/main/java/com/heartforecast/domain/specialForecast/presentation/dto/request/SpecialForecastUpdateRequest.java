package com.heartforecast.domain.specialForecast.presentation.dto.request;


public record SpecialForecastUpdateRequest(
    Long specialForecastId,
    Long childId,
    Long emotionTypeId,
    String memo
) {}
