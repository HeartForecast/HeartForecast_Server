package com.heartforecast.domain.SpecialForecastRecord.service.implementation;

import com.heartforecast.domain.SpecialForecastRecord.domain.SpecialForecastRecord;
import com.heartforecast.domain.emotionType.domain.EmotionType;
import org.springframework.stereotype.Service;

@Service
public class SpecialForecastRecordUpdater {

  public void update(SpecialForecastRecord specialForecastRecord, EmotionType emotionType, String memo) {
    specialForecastRecord.update(emotionType, memo);
  }
}
