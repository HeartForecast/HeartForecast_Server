package com.heartforecast.domain.forecast.service;

import com.heartforecast.domain.child.service.QueryChildService;
import com.heartforecast.domain.forecast.domain.Forecast;
import com.heartforecast.domain.forecast.service.implementation.ForecastReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryForecastService {

  private final ForecastReader forecastReader;
  private final QueryChildService queryChildService;

  public Forecast readOne(Long id, Long childId) {
    return forecastReader.findByChild(id, queryChildService.readOne(childId));
  }

  public List<Forecast> readAll(Long childId) {
    return forecastReader.findAllByChild(queryChildService.readOne(childId));
  }
}
