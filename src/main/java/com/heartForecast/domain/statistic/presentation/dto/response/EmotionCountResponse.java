package com.heartForecast.domain.statistic.presentation.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "특정 시간대의 감정 이름과 개수")
public record EmotionCountResponse(
    @Schema(description = "감정 이름", example = "기쁨")
    String emotionName,
    @Schema(description = "감정 빈도", example = "5")
    Long count
) {}