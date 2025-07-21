package com.heartForecast.domain.forecastRecord.service.implementation;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.forecastRecord.domain.repository.ForecastRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ForecastRecordDeleter {

  private final ForecastRecordRepository forecastRecordRepository;

  public void deleteAllByChild(Child child) {
    forecastRecordRepository.deleteAllByChild(child);
  }
}
