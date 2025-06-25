package com.heartforecast.domain.event.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Schema(description = "이벤트 수정 요청 DTO")
public record EventUpdateRequest(
    @Schema(description = "이벤트 ID", example = "10")
    Long eventId,
    @Schema(description = "이벤트 날짜 (YYYY-MM-DD)", example = "2025-07-02")
    LocalDate date,
    @Schema(description = "이벤트 제목", example = "건강검진")
    String title,
    @Schema(description = "이벤트 설명", example = "건강검진을 받아야 합니다.")
    String description
) {}