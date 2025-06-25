package com.heartForecast.domain.specialForecast.presentation.dto.response;

import com.heartForecast.domain.specialForecast.domain.SpecialForecast;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "특보 응답 DTO")
public record SpecialForecastResponse(
    @Schema(description = "특보 ID", example = "15")
    Long id,
    @Schema(description = "이벤트 ID", example = "10")
    Long eventId,
    @Schema(description = "아이 ID", example = "5")
    Long childId,
    @Schema(description = "감정 타입 ID", example = "3")
    Long emotionTypeId,
    @Schema(description = "특보 날짜 (YYYY-MM-DD)", example = "2025-06-26")
    LocalDate date,
    @Schema(description = "메모 내용", example = "수술을 받을 수도 있어요.")
    String memo
) {
  public static SpecialForecastResponse from(SpecialForecast specialForecast) {
    return new SpecialForecastResponse(
        specialForecast.getId(),
        specialForecast.getEvent().getId(),
        specialForecast.getChild().getId(),
        specialForecast.getEmotionType().getId(),
        specialForecast.getDate(),
        specialForecast.getMemo()
    );
  }
}
