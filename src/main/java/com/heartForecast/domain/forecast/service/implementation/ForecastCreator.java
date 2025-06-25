package com.heartForecast.domain.forecast.service.implementation;

import com.heartForecast.domain.forecast.domain.Forecast;
import com.heartForecast.domain.forecast.domain.repository.ForecastRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ForecastCreator {

  private final ForecastRepository forecastRepository;

  public void create(Forecast forecast) {
    forecastRepository.save(forecast);
  }
}
