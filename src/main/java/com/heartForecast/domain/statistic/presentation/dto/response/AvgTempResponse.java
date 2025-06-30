package com.heartForecast.domain.statistic.presentation.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Schema(description = "전체 기간 감정 온도 평균 응답")
public record AvgTempResponse(
    @Schema(description = "전체 기간 평균 감정 온도", example = "18.7")
    Double avgTemp
) {
    public AvgTempResponse {
        if (avgTemp != null) {
            avgTemp = BigDecimal.valueOf(avgTemp)
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
        }
    }
}
