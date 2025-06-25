package com.heartforecast.domain.heartShare.presentatioin.dto.request;

public record HeartShareUpdateRequest(
    Long heartShareId,
    String title,
    String content
) {}
