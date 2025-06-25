package com.heartForecast.domain.specialForecastRecord.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "특보 기록 수정 요청 DTO")
public record SpecialForecastRecordUpdateRequest(
    @Schema(description = "특보 기록 ID", example = "25")
    Long specialForecastRecordId,
    @Schema(description = "아이 ID", example = "5")
    Long childId,
    @Schema(description = "감정 타입 ID", example = "3")
    Long emotionTypeId,
    @Schema(description = "메모", example = "업데이트된 메모 내용")
    String memo
) {}
