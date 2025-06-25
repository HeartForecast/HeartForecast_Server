package com.heartforecast.domain.specialForecastRecord.service.implementation;

import com.heartforecast.domain.specialForecastRecord.domain.SpecialForecastRecord;
import com.heartforecast.domain.specialForecastRecord.domain.repository.SpecialForecastRecordRepository;
import com.heartforecast.domain.specialForecastRecord.exception.SpecialForecastRecordNotFoundException;
import com.heartforecast.domain.child.domain.Child;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialForecastRecordReader {

  private final SpecialForecastRecordRepository specialForecastRecordRepository;

  public SpecialForecastRecord findByChild(Long id, Child child) {
    return specialForecastRecordRepository.findByIdAndChild(id, child)
        .orElseThrow(SpecialForecastRecordNotFoundException::new);
  }

  public List<SpecialForecastRecord> findAllByChild(Child child) {
    return specialForecastRecordRepository.findAllByChildOrderByDateAsc(child);
  }
}
