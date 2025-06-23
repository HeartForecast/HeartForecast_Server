package com.heartforecast.domain.specialForecast.service.implementation;

import com.heartforecast.domain.emotionType.domain.EmotionType;
import com.heartforecast.domain.specialForecast.domain.SpecialForecast;
import org.springframework.stereotype.Service;

@Service
public class SpecialForecastUpdater {

  public void update(SpecialForecast specialForecast, EmotionType emotionType, String memo) {
    specialForecast.update(emotionType, memo);
  }
}
