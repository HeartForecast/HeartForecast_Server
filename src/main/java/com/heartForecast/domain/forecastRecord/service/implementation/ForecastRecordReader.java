package com.heartForecast.domain.forecastRecord.service.implementation;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.forecastRecord.domain.ForecastRecord;
import com.heartForecast.domain.forecastRecord.domain.repository.ForecastRecordRepository;
import com.heartForecast.domain.forecastRecord.exception.ForecastRecordNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ForecastRecordReader {

  private final ForecastRecordRepository forecastRecordRepository;

  public ForecastRecord findById(Long id) {
    return forecastRecordRepository.findById(id)
        .orElseThrow(ForecastRecordNotFoundException::new);
  }

  public ForecastRecord findByChild(Long id, Child child) {
    return forecastRecordRepository.findByIdAndChild(id, child)
        .orElseThrow(ForecastRecordNotFoundException::new);
  }

  public List<ForecastRecord> findAllByChild(Child child) {
    return forecastRecordRepository.findByChild(child);
  }

  public List<ForecastRecord> findByDateAndChild(LocalDate date, Child child) {
    return forecastRecordRepository.findByDateAndChild(date, child);
  }
}
