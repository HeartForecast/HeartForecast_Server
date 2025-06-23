package com.heartforecast.domain.SpecialForecastRecord.presentation.dto.request;

public record SpecialForecastRecordUpdateRequest(
    Long SpecialForecastRecordId,
    Long childId,
    Long emotionTypeId,
    String memo
) {}
