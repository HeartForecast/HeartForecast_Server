package com.heartForecast.domain.event.presentation.dto.request;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Hidden
@Schema(description = "이벤트 생성 요청 DTO")
public record EventCreateRequest(
    @Schema(description = "아이 ID", example = "1")
    Long childId,
    @Schema(description = "이벤트 날짜 (YYYY-MM-DD)", example = "2025-07-01")
    LocalDate date,
    @Schema(description = "이벤트 제목", example = "주사 맞기")
    String title,
    @Schema(description = "이벤트 설명", example = "주사를 맞아야 합니다.")
    String description
) {}