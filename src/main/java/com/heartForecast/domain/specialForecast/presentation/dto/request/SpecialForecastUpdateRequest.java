package com.heartForecast.domain.specialForecast.presentation.dto.request;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;

@Hidden
@Schema(description = "특보 수정 요청 DTO")
public record SpecialForecastUpdateRequest(
    @Schema(description = "특보 ID", example = "15")
    Long specialForecastId,
    @Schema(description = "아이 ID", example = "5")
    Long childId,
    @Schema(description = "감정 타입 ID", example = "3")
    Long emotionTypeId,
    @Schema(description = "메모 내용", example = "수술을 받을 수도 있어요.")
    String memo
) {}