package com.heartforecast.domain.specialForecastRecord.presentation.dto.request;

public record SpecialForecastRecordUpdateRequest(
    Long SpecialForecastRecordId,
    Long childId,
    Long emotionTypeId,
    String memo
) {}
