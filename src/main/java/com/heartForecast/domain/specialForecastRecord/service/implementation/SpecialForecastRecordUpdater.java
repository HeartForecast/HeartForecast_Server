package com.heartForecast.domain.specialForecastRecord.service.implementation;

import com.heartForecast.domain.specialForecastRecord.domain.SpecialForecastRecord;
import com.heartForecast.domain.emotionType.domain.EmotionType;
import org.springframework.stereotype.Service;

@Service
public class SpecialForecastRecordUpdater {

  public void update(SpecialForecastRecord specialForecastRecord, EmotionType emotionType, String memo) {
    specialForecastRecord.update(emotionType, memo);
  }
}
