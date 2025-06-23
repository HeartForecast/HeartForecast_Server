package com.heartforecast.domain.event.presentation.dto.request;

import java.time.LocalDate;

public record EventCreateRequest(
    Long childId,
    LocalDate date,
    String title,
    String description
) {}
