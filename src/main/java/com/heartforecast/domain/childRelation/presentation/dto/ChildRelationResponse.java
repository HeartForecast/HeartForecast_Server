package com.heartforecast.domain.childRelation.presentation.dto;

import com.heartforecast.domain.child.presentation.dto.response.ChildResponse;

public record ChildRelationResponse(
    ChildResponse childResponse,
    String role
) {
  public static ChildRelationResponse of(ChildResponse childResponse, String role) {
    return new ChildRelationResponse(childResponse, role);
  }
}
