package com.heartForecast.domain.forecast.service;

import com.heartForecast.domain.child.service.QueryChildService;
import com.heartForecast.domain.forecast.domain.Forecast;
import com.heartForecast.domain.forecast.domain.value.TimeZone;
import com.heartForecast.domain.forecast.service.implementation.ForecastReader;
import com.heartForecast.domain.forecast.service.implementation.ForecastValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryForecastService {

  private final ForecastReader forecastReader;
  private final ForecastValidator forecastValidator;
  private final QueryChildService queryChildService;

  public Forecast readOne(Long id, Long childId) {
    return forecastReader.findByChild(id, queryChildService.readOne(childId));
  }

  public List<Forecast> readAll(Long childId) {
    return forecastReader.findAllByChild(queryChildService.readOne(childId))
        .stream()
        .sorted(
            Comparator.comparing(Forecast::getDate)
                .thenComparing(f -> f.getTimeZone().getOrder())
        )
        .toList();
  }

  public List<Forecast> findDate(LocalDate date, Long childId) {
    return forecastReader.findByDateAndChild(date, queryChildService.readOne(childId))
        .stream()
        .sorted(Comparator.comparing(f -> f.getTimeZone().getOrder()))
        .toList();
  }

  public void existsByDateAndTimeZone(Long childId, LocalDate date, TimeZone timeZone) {
    forecastValidator.existsByChildAndDateAndTimeZone(queryChildService.readOne(childId), date, timeZone);
  }

  public boolean hasForecastRecord(Long id, Long childId) {
    return forecastReader.existsByForecast(forecastReader.findByChild(id, queryChildService.readOne(childId)));
  }
}
