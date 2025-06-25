package com.heartforecast.domain.childRelation.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "돌봄관계 생성 요청 DTO")
public record ChildRelationJoinRequest(
    @Schema(description = "아이의 초대 코드", example = "ABCD1234")
    String inviteCode,
    @Schema(description = "관계 유형 (예: 부모, 보호자)", example = "엄마")
    String role
) {}
