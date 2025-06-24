package com.heartforecast.domain.forecastRecord.service;

import com.heartforecast.domain.child.service.QueryChildService;
import com.heartforecast.domain.forecast.service.QueryForecastService;
import com.heartforecast.domain.forecastRecord.domain.ForecastRecord;
import com.heartforecast.domain.forecastRecord.service.implementation.ForecastRecordReader;
import com.heartforecast.domain.forecastRecord.service.implementation.ForecastRecordValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryForecastRecordService {

  private final ForecastRecordReader forecastRecordReader;
  private final ForecastRecordValidator forecastRecordValidator;
  private final QueryChildService queryChildService;
  private final QueryForecastService queryForecastService;

  public ForecastRecord readOne(Long id, Long childId) {
    return forecastRecordReader.findByChild(id, queryChildService.readOne(childId));
  }

  public List<ForecastRecord> readAll(Long childId) {
    return forecastRecordReader.findAllByChild(queryChildService.readOne(childId))
        .stream()
        .sorted(
            Comparator.comparing(ForecastRecord::getDate)
                .thenComparing(f -> f.getTimeZone().getOrder())
        )
        .toList();
  }

  public List<ForecastRecord> findDate(LocalDate date, Long childId) {
    return forecastRecordReader.findByDateAndChild(date, queryChildService.readOne(childId))
        .stream()
        .sorted(Comparator.comparing(f -> f.getTimeZone().getOrder()))
        .toList();
  }

  public void existsByForecast(Long forecastId, Long childId) {
    forecastRecordValidator.existsByForecast(queryForecastService.readOne(forecastId, childId));
  }
}
