package com.heartforecast.domain.specialForecast.service.implementation;

import com.heartforecast.domain.specialForecast.domain.SpecialForecast;
import com.heartforecast.domain.specialForecast.domain.repository.SpecialForecastRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecialForecastCreator {

  private final SpecialForecastRepository specialForecastRepository;

  public void create(SpecialForecast specialForecast) {
    specialForecastRepository.save(specialForecast);
  }
}
