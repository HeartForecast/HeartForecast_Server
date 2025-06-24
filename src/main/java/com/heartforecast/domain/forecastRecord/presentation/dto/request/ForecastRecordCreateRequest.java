package com.heartforecast.domain.forecastRecord.presentation.dto.request;

import com.heartforecast.domain.forecast.domain.value.TimeZone;

import java.time.LocalDate;

public record ForecastRecordCreateRequest(
    Long forecastId,
    Long childId,
    Long emotionTypeId,
    LocalDate date,
    TimeZone timeZone,
    String memo
) {}
