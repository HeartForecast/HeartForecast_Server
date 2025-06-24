package com.heartforecast.domain.forecastRecord.service.implementation;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.forecastRecord.domain.ForecastRecord;
import com.heartforecast.domain.forecastRecord.domain.repository.ForecastRecordRepository;
import com.heartforecast.domain.forecastRecord.exception.ForecastRecordNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ForecastRecordReader {

  private final ForecastRecordRepository forecastRecordRepository;

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
