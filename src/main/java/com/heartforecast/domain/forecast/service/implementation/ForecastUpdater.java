package com.heartforecast.domain.forecast.service.implementation;

import com.heartforecast.domain.emotionType.domain.EmotionType;
import com.heartforecast.domain.forecast.domain.Forecast;
import org.springframework.stereotype.Service;

@Service
public class ForecastUpdater {

  public void update(Forecast forecast, EmotionType emotionType, String memo) {
    forecast.update(emotionType, memo);
  }
}
