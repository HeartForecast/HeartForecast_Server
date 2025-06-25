package com.heartforecast.domain.childRelation.presentation.dto.response;

import com.heartforecast.domain.child.presentation.dto.response.ChildResponse;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "돌봄관계 반환 DTO")
public record ChildRelationResponse(
    @Schema(description = "아이 정보")
    ChildResponse childResponse,
    @Schema(description = "관계 유형 (예: 부모, 보호자)", example = "엄마")
    String role
) {
  public static ChildRelationResponse of(ChildResponse childResponse, String role) {
    return new ChildRelationResponse(childResponse, role);
  }
}
