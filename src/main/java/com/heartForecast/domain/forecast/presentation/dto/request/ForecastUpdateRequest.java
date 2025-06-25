package com.heartForecast.domain.forecast.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "예보 수정 요청 DTO")
public record ForecastUpdateRequest(
    @Schema(description = "예보 ID", example = "10")
    Long forecastId,
    @Schema(description = "아이 ID", example = "1")
    Long childId,
    @Schema(description = "감정 유형 ID", example = "3")
    Long emotionTypeId,
    @Schema(description = "메모", example = "오늘은 활발함")
    String memo
) {}
