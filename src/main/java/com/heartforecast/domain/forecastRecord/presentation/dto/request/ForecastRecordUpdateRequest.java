package com.heartforecast.domain.forecastRecord.presentation.dto.request;

public record ForecastRecordUpdateRequest(
    Long forecastRecordId,
    Long childId,
    Long emotionTypeId,
    String memo
) {}
