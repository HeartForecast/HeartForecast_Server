package com.heartForecast.domain.statistic.presentation.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "감정별 오차율 응답")
public record EmotionErrorRateResponse(
    @Schema(description = "감정 이름", example = "기쁨")
    String emotionName,
    @Schema(description = "발생 횟수", example = "10")
    Long count,
    @Schema(description = "오차율 (평균 대비 상대적 차이, -1.0~1.0)", example = "0.25")
    Double errorRate
) {}