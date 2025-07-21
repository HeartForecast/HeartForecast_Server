package com.heartForecast.domain.forecast.service.implementation;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.forecast.domain.repository.ForecastRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ForecastDeleter {

  private final ForecastRepository forecastRepository;

  public void deleteAllByChild(Child child) {
    forecastRepository.deleteAllByChild(child);
  }
}
