package com.heartforecast.domain.child.presentation.dto.request;

public record ChildUpdateHealthRequest(
    Long childId,
    String healthInfo
) {}
