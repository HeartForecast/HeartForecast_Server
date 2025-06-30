package com.heartForecast.domain.statistic.presentation.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "시간대별 감정 분포 정보")
public record TimeZoneEmotionGroupResponse(
    @Schema(description = "시간대", example = "아침")
    String timeZone,
    @Schema(description = "해당 시간대 감정 목록")
    List<EmotionCountResponse> emotions
) {}