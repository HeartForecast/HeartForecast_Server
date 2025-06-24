package com.heartforecast.domain.forecast.presentation.dto.request;

import com.heartforecast.domain.forecast.domain.value.TimeZone;

import java.time.LocalDate;

public record ForecastCreateRequest(
    Long childId,
    Long emotionTypeId,
    LocalDate date,
    TimeZone timeZone,
    String memo
) {}
