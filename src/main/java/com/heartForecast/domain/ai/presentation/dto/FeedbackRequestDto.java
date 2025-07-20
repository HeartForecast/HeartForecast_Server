package com.heartForecast.domain.ai.presentation.dto;

public record FeedbackRequestDto(
    String childHealthInfo,
    EmotionRecord morningForecast,
    EmotionRecord lunchForecast,
    EmotionRecord eveningForecast,
    EmotionRecord morningForecastRecord,
    EmotionRecord lunchForecastRecord,
    EmotionRecord eveningForecastRecord
) {}