package com.heartforecast.domain.specialForecastRecord.service.implementation;

import com.heartforecast.domain.specialForecastRecord.domain.SpecialForecastRecord;
import com.heartforecast.domain.specialForecastRecord.domain.repository.SpecialForecastRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecialForecastRecordCreator {

  private final SpecialForecastRecordRepository specialForecastRecordRepository;

  public void create(SpecialForecastRecord specialForecastRecord) {
    specialForecastRecordRepository.save(specialForecastRecord);
  }
}
