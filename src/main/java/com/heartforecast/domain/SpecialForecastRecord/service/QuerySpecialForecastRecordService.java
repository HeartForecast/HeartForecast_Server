package com.heartforecast.domain.SpecialForecastRecord.service;

import com.heartforecast.domain.SpecialForecastRecord.domain.SpecialForecastRecord;
import com.heartforecast.domain.SpecialForecastRecord.service.implementation.SpecialForecastRecordReader;
import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.child.service.QueryChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuerySpecialForecastRecordService {

  private final SpecialForecastRecordReader specialForecastRecordReader;
  private final QueryChildService queryChildService;

  public SpecialForecastRecord readOne(Long specialForecastRecordId, Long childId) {
    Child child = queryChildService.readOne(childId);

    return specialForecastRecordReader.findByIdAndChild(specialForecastRecordId, child);
  }

  public List<SpecialForecastRecord> readAll(Long childId) {
    Child child = queryChildService.readOne(childId);

    return specialForecastRecordReader.findAllByChild(child);
  }
}
