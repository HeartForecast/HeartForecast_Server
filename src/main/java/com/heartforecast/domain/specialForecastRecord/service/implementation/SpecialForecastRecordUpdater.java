package com.heartforecast.domain.specialForecastRecord.service.implementation;

import com.heartforecast.domain.specialForecastRecord.domain.SpecialForecastRecord;
import com.heartforecast.domain.emotionType.domain.EmotionType;
import org.springframework.stereotype.Service;

@Service
public class SpecialForecastRecordUpdater {

  public void update(SpecialForecastRecord specialForecastRecord, EmotionType emotionType, String memo) {
    specialForecastRecord.update(emotionType, memo);
  }
}
