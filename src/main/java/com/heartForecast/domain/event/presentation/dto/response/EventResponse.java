package com.heartForecast.domain.event.presentation.dto.response;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Hidden
@Schema(description = "이벤트 응답 DTO")
public record EventResponse(
    @Schema(description = "이벤트 ID", example = "10")
    Long eventId,
    @Schema(description = "아이 ID", example = "1")
    Long childId,
    @Schema(description = "이벤트 날짜 (YYYY-MM-DD)", example = "2025-07-01")
    LocalDate date,
    @Schema(description = "이벤트 제목", example = "건강검진")
    String title,
    @Schema(description = "이벤트 설명", example = "건강검진을 받아야 합니다.")
    String description
) {
  public static EventResponse from(Long eventId, Long childId, LocalDate date, String title, String description) {
    return new EventResponse(eventId, childId, date, title, description);
  }
}

