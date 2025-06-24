package com.heartforecast.domain.forecast.service.implementation;

import com.heartforecast.domain.forecast.domain.Forecast;
import com.heartforecast.domain.forecast.domain.repository.ForecastRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ForecastDeleter {

  private final ForecastRepository forecastRepository;

  public void delete(Forecast forecast) {
    forecastRepository.delete(forecast);
  }
}
