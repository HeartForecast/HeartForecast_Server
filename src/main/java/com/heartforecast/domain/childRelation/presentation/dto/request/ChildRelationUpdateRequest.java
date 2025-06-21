package com.heartforecast.domain.childRelation.presentation.dto.request;

public record ChildRelationUpdateRequest(
    Long childId,
    String role
) {}
