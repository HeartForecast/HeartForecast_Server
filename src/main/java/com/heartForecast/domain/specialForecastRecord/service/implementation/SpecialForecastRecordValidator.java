package com.heartForecast.domain.specialForecastRecord.service.implementation;

import com.heartForecast.domain.specialForecastRecord.domain.repository.SpecialForecastRecordRepository;
import com.heartForecast.domain.specialForecastRecord.exception.SpecialForecastRecordAlreadyExistsException;
import com.heartForecast.domain.specialForecast.domain.SpecialForecast;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecialForecastRecordValidator {

  private final SpecialForecastRecordRepository specialForecastRecordRepository;

  public void validate(SpecialForecast specialForecast) {
    if (specialForecastRecordRepository.existsBySpecialForecast(specialForecast)) throw new SpecialForecastRecordAlreadyExistsException();
  }
}
