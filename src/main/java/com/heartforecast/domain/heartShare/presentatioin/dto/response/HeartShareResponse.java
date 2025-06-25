package com.heartforecast.domain.heartShare.presentatioin.dto.response;

import com.heartforecast.domain.heartShare.domain.HeartShare;

public record HeartShareResponse(
    Long id,
    Long userId,
    String title,
    String content
) {
  public static HeartShareResponse from(HeartShare heartShare) {
    return new HeartShareResponse(
        heartShare.getId(),
        heartShare.getUser().getId(),
        heartShare.getTitle(),
        heartShare.getContent()
    );
  }
}
