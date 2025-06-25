package com.heartforecast.domain.forecastRecord.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "예보 기록 수정 요청 DTO")
public record ForecastRecordUpdateRequest(
    @Schema(description = "예보 기록 ID", example = "15")
    Long forecastRecordId,
    @Schema(description = "아이 ID", example = "1")
    Long childId,
    @Schema(description = "감정 유형 ID", example = "3")
    Long emotionTypeId,
    @Schema(description = "메모", example = "오늘은 조금 피곤해 보임")
    String memo
) {}