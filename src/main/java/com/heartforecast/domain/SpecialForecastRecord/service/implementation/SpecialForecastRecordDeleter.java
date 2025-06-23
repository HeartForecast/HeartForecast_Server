package com.heartforecast.domain.SpecialForecastRecord.service.implementation;

import com.heartforecast.domain.SpecialForecastRecord.domain.SpecialForecastRecord;
import com.heartforecast.domain.SpecialForecastRecord.domain.repository.SpecialForecastRecordRepository;
import com.heartforecast.domain.specialForecast.domain.SpecialForecast;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecialForecastRecordDeleter {

  private final SpecialForecastRecordRepository specialForecastRecordRepository;

  public void delete(SpecialForecastRecord specialForecastRecord) {
    specialForecastRecordRepository.delete(specialForecastRecord);
  }

  public void deleteBySpecialForecast(SpecialForecast specialForecast) {
    specialForecastRecordRepository.deleteBySpecialForecast(specialForecast);
  }
}
