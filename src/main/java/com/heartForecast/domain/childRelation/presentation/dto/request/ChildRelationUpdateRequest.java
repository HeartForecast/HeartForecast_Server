package com.heartForecast.domain.childRelation.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "돌봄관계 변경 요청 DTO")
public record ChildRelationUpdateRequest(
    @Schema(description = "아이 ID", example = "1")
    Long childId,
    @Schema(description = "관계 유형 (예: 부모, 보호자, 대리인 등)", example = "아빠")
    String role
) {}
