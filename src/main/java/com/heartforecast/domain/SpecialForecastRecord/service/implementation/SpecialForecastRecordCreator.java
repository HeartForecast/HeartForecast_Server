package com.heartforecast.domain.SpecialForecastRecord.service.implementation;

import com.heartforecast.domain.SpecialForecastRecord.domain.SpecialForecastRecord;
import com.heartforecast.domain.SpecialForecastRecord.domain.repository.SpecialForecastRecordRepository;
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
