package com.heartforecast.domain.specialForecastRecord.service.implementation;

import com.heartforecast.domain.specialForecastRecord.domain.SpecialForecastRecord;
import com.heartforecast.domain.specialForecastRecord.domain.repository.SpecialForecastRecordRepository;
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
