package com.heartforecast.domain.event.presentation.dto.response;

import java.time.LocalDate;

public record EventResponse(
    Long childId,
    LocalDate date,
    String title,
    String description
) {
  public static EventResponse from(Long childId, LocalDate date, String title, String description) {
    return new EventResponse(childId, date, title, description);
  }
}
