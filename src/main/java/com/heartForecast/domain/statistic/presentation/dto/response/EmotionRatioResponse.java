package com.heartForecast.domain.statistic.presentation.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "감정별 비율 통계 응답")
public record EmotionRatioResponse(
    @Schema(description = "감정 이름", example = "기쁨")
    String emotionName,
    @Schema(description = "총 등장 횟수", example = "6")
    Long count,
    @Schema(description = "비율 (0~1)", example = "0.5")
    Double ratio
) {}