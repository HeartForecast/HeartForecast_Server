package com.heartforecast.domain.event.presentation.dto.request;

import java.time.LocalDate;

public record EventUpdateRequest(
    Long eventId,
    LocalDate date,
    String title,
    String description
) {}
