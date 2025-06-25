package com.heartforecast.domain.heartShare.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "마음공유 수정 요청 DTO")
public record HeartShareUpdateRequest(
    @Schema(description = "마음공유 ID", example = "5")
    Long heartShareId,
    @Schema(description = "게시글 제목", example = "업데이트된 오늘의 마음")
    String title,
    @Schema(description = "게시글 내용", example = "오늘은 조금 힘든 하루였습니다.")
    String content
) {}