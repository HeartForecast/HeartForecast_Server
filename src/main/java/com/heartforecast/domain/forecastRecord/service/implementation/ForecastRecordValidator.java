package com.heartforecast.domain.forecastRecord.service.implementation;

import com.heartforecast.domain.forecast.domain.Forecast;
import com.heartforecast.domain.forecastRecord.domain.ForecastRecord;
import com.heartforecast.domain.forecastRecord.domain.repository.ForecastRecordRepository;
import com.heartforecast.domain.forecastRecord.exception.ForecastRecordAlreadyExistsException;
import com.heartforecast.domain.forecastRecord.exception.ForecastRecordUpdateTimeExpiredException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ForecastRecordValidator {

  private final ForecastRecordRepository forecastRecordRepository;

  public void existsByForecast(Forecast forecast) {
    if (forecastRecordRepository.existsByForecast(forecast)) throw new ForecastRecordAlreadyExistsException();
  }

  public void overUpdateTimeExpire(ForecastRecord forecastRecord) {
    if (forecastRecord.getCreatedAt().isBefore(LocalDateTime.now().minusHours(24))) throw new ForecastRecordUpdateTimeExpiredException();
  }
}