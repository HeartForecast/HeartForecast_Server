package com.heartForecast.domain.specialForecastRecord.presentation.dto.request;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Hidden
@Schema(description = "특보 기록 생성 요청 DTO")
public record SpecialForecastRecordCreateRequest(
    @Schema(description = "특보 ID", example = "12")
    Long specialForecastId,
    @Schema(description = "아이 ID", example = "5")
    Long childId,
    @Schema(description = "감정 타입 ID", example = "3")
    Long emotionTypeId,
    @Schema(description = "날짜 (YYYY-MM-DD)", example = "2025-06-26")
    LocalDate date,
    @Schema(description = "메모", example = "특별한 주의 필요")
    String memo
) {}
