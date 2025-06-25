package com.heartforecast.domain.specialForecastRecord.service.implementation;

import com.heartforecast.domain.specialForecastRecord.domain.repository.SpecialForecastRecordRepository;
import com.heartforecast.domain.specialForecastRecord.exception.SpecialForecastRecordAlreadyExistsException;
import com.heartforecast.domain.specialForecast.domain.SpecialForecast;
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
