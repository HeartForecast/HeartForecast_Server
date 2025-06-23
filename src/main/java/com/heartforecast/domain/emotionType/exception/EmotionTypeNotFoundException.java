package com.heartforecast.domain.emotionType.exception;

import com.heartforecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class EmotionTypeNotFoundException extends HeartForecastException {
  public EmotionTypeNotFoundException() {
    super(HttpStatus.NOT_FOUND, "EMOTION_TYPE_NOT_FOUND", "감정 종류를 찾을 수 없습니다.");
  }
}
