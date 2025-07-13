package com.heartForecast.domain.forecastRecord.service;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.child.service.QueryChildService;
import com.heartForecast.domain.forecast.service.QueryForecastService;
import com.heartForecast.domain.forecastRecord.domain.ForecastRecord;
import com.heartForecast.domain.forecastRecord.service.implementation.ForecastRecordReader;
import com.heartForecast.domain.forecastRecord.service.implementation.ForecastRecordValidator;
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

  public ForecastRecord readOne(Long id) {
    return forecastRecordReader.findById(id);
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

  public ForecastRecord findOne(Long id, Long childId) {
    return forecastRecordReader.findByChild(id, queryChildService.readOne(childId));
  }

  public List<ForecastRecord> findDate(LocalDate date, Long childId) {
    return forecastRecordReader.findByDateAndChild(date, queryChildService.readOne(childId))
        .stream()
        .sorted(Comparator.comparing(f -> f.getTimeZone().getOrder()))
        .toList();
  }

  public void existsByForecast(Long forecastId, Long childId) {
    forecastRecordValidator.existsByForecast(queryForecastService.findOne(forecastId, childId));
  }

  public void overUpdateTimeExpire(Long forecastRecordId, Long childId) {
    Child child = queryChildService.readOne(childId);

    forecastRecordValidator.overUpdateTimeExpire(forecastRecordReader.findByChild(forecastRecordId, child));
  }
}
