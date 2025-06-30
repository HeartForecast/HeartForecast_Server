package com.heartForecast.domain.statistic.presentation.dto.response;

import com.heartForecast.domain.forecastRecord.domain.value.TimeZone;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "시간대별 감정 카운트 정보")
public record TimeZoneEmotionCountResponse(
    @Schema(description = "시간대 (아침, 점심, 저녁)", example = "아침")
    TimeZone timeZone,
    @Schema(description = "감정 이름", example = "기쁨")
    String emotionName,
    @Schema(description = "해당 시간대에 감정이 나타난 횟수", example = "4")
    Long count
) {}