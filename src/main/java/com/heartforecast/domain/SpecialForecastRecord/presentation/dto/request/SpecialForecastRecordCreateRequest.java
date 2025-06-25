package com.heartforecast.domain.SpecialForecastRecord.presentation.dto.request;

import java.time.LocalDate;

public record SpecialForecastRecordCreateRequest(
    Long specialForecastId,
    Long childId,
    Long emotionTypeId,
    LocalDate date,
    String memo
) {}
