package com.heartforecast.domain.specialForecast.presentation.dto.request;


import java.time.LocalDate;

public record SpecialForecastCreateRequest(
    Long eventId,
    Long childId,
    Long emotionTypeId,
    LocalDate date,
    String memo
) {}
