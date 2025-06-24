package com.heartforecast.domain.forecastRecord.service.implementation;

import com.heartforecast.domain.emotionType.domain.EmotionType;
import com.heartforecast.domain.forecastRecord.domain.ForecastRecord;
import org.springframework.stereotype.Service;

@Service
public class ForecastRecordUpdater {

  public void update(ForecastRecord forecastRecord, EmotionType emotionType, String memo) {
    forecastRecord.update(emotionType, memo);
  }
}
