package com.heartForecast.domain.childRelation.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "돌봄관계 생성 요청 DTO")
public record ChildRelationJoinRequest(
    @Schema(description = "아이의 초대 코드", example = "123456")
    String inviteCode
) {}