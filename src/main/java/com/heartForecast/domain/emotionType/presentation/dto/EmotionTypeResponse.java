package com.heartForecast.domain.emotionType.presentation.dto;

import com.heartForecast.domain.emotionType.domain.EmotionType;
import com.heartForecast.domain.emotionType.domain.value.Type;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "감정 타입 응답 DTO")
public record EmotionTypeResponse(
    @Schema(description = "감정 타입 ID", example = "1")
    Long id,
    @Schema(description = "감정 이름", example = "행복한")
    String name,
    @Schema(description = "감정 분류 (긍정, 중립, 부정)", example = "긍정")
    Type type,
    @Schema(description = "감정에 해당하는 체감 온도", example = "25.0")
    float temp,
    @Schema(description = "감정과 어울리는 날씨 이미지 URL", example = "https://example.com/emotion/happy.png")
    String image
) {
  public static EmotionTypeResponse from(EmotionType emotionType) {
    return new EmotionTypeResponse(
        emotionType.getId(),
        emotionType.getName(),
        emotionType.getType(),
        emotionType.getTemp(),
        emotionType.getImage()
    );
  }
}
