package com.heartForecast.domain.specialForecast.service.implementation;

import com.heartForecast.domain.emotionType.domain.EmotionType;
import com.heartForecast.domain.specialForecast.domain.SpecialForecast;
import org.springframework.stereotype.Service;

@Service
public class SpecialForecastUpdater {

  public void update(SpecialForecast specialForecast, EmotionType emotionType, String memo) {
    specialForecast.update(emotionType, memo);
  }
}
