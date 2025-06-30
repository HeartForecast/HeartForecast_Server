package com.heartForecast.domain.statistic.presentation.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Schema(description = "일자별 평균 감정 온도 응답")
public record DateTempResponse(
    @Schema(description = "기록된 날짜", example = "2025-06-30")
    LocalDate date,
    @Schema(description = "해당 날짜의 평균 감정 온도", example = "19.5")
    Double avgTemp
) {
    public DateTempResponse {
        if (avgTemp != null) {
            avgTemp = BigDecimal.valueOf(avgTemp)
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
        }
    }
}

