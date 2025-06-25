package com.heartforecast.domain.heartShare.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "마음공유 생성 요청 DTO")
public record HeartShareCreateRequest(
    @Schema(description = "게시글 제목", example = "오늘의 마음")
    String title,
    @Schema(description = "게시글 내용", example = "오늘은 정말 행복한 하루였습니다.")
    String content
) {}