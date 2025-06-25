package com.heartForecast.domain.forecast.service.implementation;

import com.heartForecast.domain.emotionType.domain.EmotionType;
import com.heartForecast.domain.forecast.domain.Forecast;
import org.springframework.stereotype.Service;

@Service
public class ForecastUpdater {

  public void update(Forecast forecast, EmotionType emotionType, String memo) {
    forecast.update(emotionType, memo);
  }
}
