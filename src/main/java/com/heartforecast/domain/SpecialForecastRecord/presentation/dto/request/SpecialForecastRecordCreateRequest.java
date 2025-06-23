package com.heartforecast.domain.SpecialForecastRecord.presentation.dto.request;

public record SpecialForecastRecordCreateRequest(
    Long specialForecastId,
    Long childId,
    Long emotionTypeId,
    String memo
) {}
