package com.heartForecast.domain.heartShare.presentation.dto.response;

import com.heartForecast.domain.heartShare.domain.HeartShare;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "마음공유 응답 DTO")
public record HeartShareResponse(
    @Schema(description = "마음공유 ID", example = "5")
    Long id,
    @Schema(description = "사용자 ID", example = "1")
    Long userId,
    @Schema(description = "게시글 제목", example = "오늘의 마음")
    String title,
    @Schema(description = "게시글 내용", example = "오늘은 정말 행복한 하루였습니다.")
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
