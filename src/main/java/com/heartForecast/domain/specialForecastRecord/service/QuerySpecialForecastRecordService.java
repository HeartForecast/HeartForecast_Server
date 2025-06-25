package com.heartForecast.domain.specialForecastRecord.service;

import com.heartForecast.domain.specialForecastRecord.domain.SpecialForecastRecord;
import com.heartForecast.domain.specialForecastRecord.service.implementation.SpecialForecastRecordReader;
import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.child.service.QueryChildService;
import com.heartForecast.domain.specialForecast.service.implementation.SpecialForecastValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuerySpecialForecastRecordService {

  private final SpecialForecastRecordReader specialForecastRecordReader;
  private final SpecialForecastValidator specialForecastValidator;
  private final QueryChildService queryChildService;

  public SpecialForecastRecord readOne(Long specialForecastRecordId, Long childId) {
    Child child = queryChildService.readOne(childId);

    return specialForecastRecordReader.findByChild(specialForecastRecordId, child);
  }

  public List<SpecialForecastRecord> readAll(Long childId) {
    Child child = queryChildService.readOne(childId);

    return specialForecastRecordReader.findAllByChild(child);
  }

  public void overUpdateTimeExpire(Long specialForecastRecordId, Long childId) {
    Child child = queryChildService.readOne(childId);

    specialForecastValidator.overUpdateTimeExpire(specialForecastRecordReader.findByChild(specialForecastRecordId, child));
  }
}
