package com.heartforecast.domain.specialForecast.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "특보 생성 요청 DTO")
public record SpecialForecastCreateRequest(
    @Schema(description = "이벤트 ID", example = "10")
    Long eventId,
    @Schema(description = "아이 ID", example = "5")
    Long childId,
    @Schema(description = "감정 타입 ID", example = "3")
    Long emotionTypeId,
    @Schema(description = "특보 날짜 (YYYY-MM-DD)", example = "2025-06-26")
    LocalDate date,
    @Schema(description = "메모 내용", example = "수술을 받아야 해요.")
    String memo
) {}