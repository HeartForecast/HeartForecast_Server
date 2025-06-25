package com.heartforecast.domain.forecast.presentation.dto.request;

import com.heartforecast.domain.forecast.domain.value.TimeZone;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "예보 생성 요청 DTO")
public record ForecastCreateRequest(
    @Schema(description = "아이 ID", example = "1")
    Long childId,
    @Schema(description = "감정 유형 ID", example = "3")
    Long emotionTypeId,
    @Schema(description = "예보 날짜 (YYYY-MM-DD)", example = "2025-06-25")
    LocalDate date,
    @Schema(description = "예보 시간대 (아침, 점심, 저녁)", example = "아침")
    TimeZone timeZone,
    @Schema(description = "메모", example = "아이 상태가 좋음")
    String memo
) {}