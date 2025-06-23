package com.heartforecast.domain.specialForecast.service.implementation;

import com.heartforecast.domain.event.domain.Event;
import com.heartforecast.domain.specialForecast.domain.repository.SpecialForecastRepository;
import com.heartforecast.domain.specialForecast.exception.SpecialForecastAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecialForecastValidator {

  private final SpecialForecastRepository specialForecastRepository;

  public void validate(Event event) {
    if (specialForecastRepository.existsByEvent(event)) throw new SpecialForecastAlreadyExistsException();
  }
}
