package com.heartForecast.domain.forecastRecord.service.implementation;

import com.heartForecast.domain.forecastRecord.domain.ForecastRecord;
import com.heartForecast.domain.forecastRecord.domain.repository.ForecastRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ForecastRecordCreator {

  private final ForecastRecordRepository forecastRecordRepository;

  public void create(ForecastRecord forecastRecord) {
    forecastRecordRepository.save(forecastRecord);
  }
}
