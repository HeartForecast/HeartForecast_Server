package com.heartforecast.domain.forecast.presentation.dto.request;

public record ForecastUpdateRequest(
    Long forecastId,
    Long childId,
    Long emotionTypeId,
    String memo
) {}
