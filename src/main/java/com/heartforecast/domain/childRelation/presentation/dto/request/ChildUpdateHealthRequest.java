package com.heartforecast.domain.childRelation.presentation.dto.request;

public record ChildUpdateHealthRequest(
    Long childId,
    String healthInfo
) {
}
