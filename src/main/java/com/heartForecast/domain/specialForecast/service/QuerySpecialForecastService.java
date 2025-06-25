package com.heartForecast.domain.specialForecast.service;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.child.service.QueryChildService;
import com.heartForecast.domain.event.service.QueryEventService;
import com.heartForecast.domain.specialForecast.domain.SpecialForecast;
import com.heartForecast.domain.specialForecast.service.implementation.SpecialForecastReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuerySpecialForecastService {

  private final SpecialForecastReader specialForecastReader;
  private final QueryChildService queryChildService;
  private final QueryEventService queryEventService;

  public SpecialForecast readOne(Long specialForecastId, Long childId) {
    Child child = queryChildService.readOne(childId);

    return specialForecastReader.findByIdAndChild(specialForecastId, child);
  }

  public List<SpecialForecast> readAll(Long childId) {
    Child child = queryChildService.readOne(childId);

    return specialForecastReader.findAllByChild(child);
  }

  public SpecialForecast findByEvent(Long eventId, Long userId) {
    return specialForecastReader.findByEvent(queryEventService.findOneByUser(eventId, userId));
  }
}
