package com.heartforecast.domain.specialForecast.service;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.child.service.QueryChildService;
import com.heartforecast.domain.specialForecast.domain.SpecialForecast;
import com.heartforecast.domain.specialForecast.service.implementation.SpecialForecastReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuerySpecialForecastService {

  private final SpecialForecastReader specialForecastReader;
  private final QueryChildService queryChildService;

  public SpecialForecast readOne(Long specialForecastId, Long childId) {
    Child child = queryChildService.readOne(childId);

    return specialForecastReader.findByIdAndChild(specialForecastId, child);
  }
}
