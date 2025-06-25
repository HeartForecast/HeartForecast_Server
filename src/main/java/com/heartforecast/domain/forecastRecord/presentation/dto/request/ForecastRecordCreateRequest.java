package com.heartforecast.domain.forecastRecord.presentation.dto.request;

import com.heartforecast.domain.forecastRecord.domain.value.TimeZone;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Schema(description = "예보 기록 생성 요청 DTO")
public record ForecastRecordCreateRequest(
    @Schema(description = "예보 ID", example = "10")
    Long forecastId,
    @Schema(description = "아이 ID", example = "1")
    Long childId,
    @Schema(description = "감정 유형 ID", example = "3")
    Long emotionTypeId,
    @Schema(description = "예보 기록 날짜 (YYYY-MM-DD)", example = "2025-06-25")
    LocalDate date,
    @Schema(description = "예보 기록 시간대 (아침, 점심, 저녁)", example = "아침")
    TimeZone timeZone,
    @Schema(description = "메모", example = "아이가 활발했습니다")
    String memo
) {}