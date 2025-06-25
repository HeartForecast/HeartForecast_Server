package com.heartforecast.domain.specialForecast.service.implementation;

import com.heartforecast.domain.SpecialForecastRecord.domain.SpecialForecastRecord;
import com.heartforecast.domain.SpecialForecastRecord.exception.SpecialForecastRecordUpdateTimeExpiredException;
import com.heartforecast.domain.event.domain.Event;
import com.heartforecast.domain.specialForecast.domain.repository.SpecialForecastRepository;
import com.heartforecast.domain.specialForecast.exception.SpecialForecastAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SpecialForecastValidator {

  private final SpecialForecastRepository specialForecastRepository;

  public void existsByEvent(Event event) {
    if (specialForecastRepository.existsByEvent(event)) throw new SpecialForecastAlreadyExistsException();
  }

  public void overUpdateTimeExpire(SpecialForecastRecord specialForecastRecord) {
    if (specialForecastRecord.getCreatedAt().isBefore(LocalDateTime.now().minusHours(24))) throw new SpecialForecastRecordUpdateTimeExpiredException();
  }
}
