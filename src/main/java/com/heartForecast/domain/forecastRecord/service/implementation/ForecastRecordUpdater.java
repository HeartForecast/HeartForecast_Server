package com.heartForecast.domain.forecastRecord.service.implementation;

import com.heartForecast.domain.emotionType.domain.EmotionType;
import com.heartForecast.domain.forecastRecord.domain.ForecastRecord;
import org.springframework.stereotype.Service;

@Service
public class ForecastRecordUpdater {

  public void update(ForecastRecord forecastRecord, EmotionType emotionType, String memo) {
    forecastRecord.update(emotionType, memo);
  }
}
