package com.heartForecast.domain.ai.presentation;

import com.heartForecast.domain.ai.presentation.dto.FeedbackRequestDto;
import com.heartForecast.domain.ai.service.GeminiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feedback")
@RequiredArgsConstructor
public class AiController {

  private final GeminiService geminiService;

  @PostMapping
  public String getFeedback(@RequestBody FeedbackRequestDto requestDto) {
    return geminiService.generateFeedback(requestDto);
  }
}
