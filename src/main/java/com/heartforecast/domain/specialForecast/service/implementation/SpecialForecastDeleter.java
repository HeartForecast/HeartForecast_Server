package com.heartforecast.domain.specialForecast.service.implementation;

import com.heartforecast.domain.event.domain.Event;
import com.heartforecast.domain.specialForecast.domain.SpecialForecast;
import com.heartforecast.domain.specialForecast.domain.repository.SpecialForecastRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecialForecastDeleter {

  private final SpecialForecastRepository specialForecastRepository;

  public void delete(SpecialForecast specialForecast) {
    specialForecastRepository.delete(specialForecast);
  }

  public void deleteByEvent(Event event) {
    specialForecastRepository.deleteByEvent(event);
  }
}
