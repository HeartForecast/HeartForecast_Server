package com.heartforecast.domain.SpecialForecastRecord.service.implementation;

import com.heartforecast.domain.SpecialForecastRecord.domain.SpecialForecastRecord;
import com.heartforecast.domain.SpecialForecastRecord.domain.repository.SpecialForecastRecordRepository;
import com.heartforecast.domain.SpecialForecastRecord.exception.SpecialForecastRecordNotFoundException;
import com.heartforecast.domain.child.domain.Child;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialForecastRecordReader {

  private final SpecialForecastRecordRepository specialForecastRecordRepository;

  public SpecialForecastRecord findByIdAndChild(Long id, Child child) {
    return specialForecastRecordRepository.findByIdAndChild(id, child)
        .orElseThrow(SpecialForecastRecordNotFoundException::new);
  }

  public List<SpecialForecastRecord> findAllByChild(Child child) {
    return specialForecastRecordRepository.findAllByChild(child);
  }
}
