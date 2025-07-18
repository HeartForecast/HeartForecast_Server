package com.heartForecast.domain.specialForecast.service.implementation;

import com.heartForecast.domain.specialForecastRecord.domain.SpecialForecastRecord;
import com.heartForecast.domain.specialForecastRecord.exception.SpecialForecastRecordUpdateTimeExpiredException;
import com.heartForecast.domain.event.domain.Event;
import com.heartForecast.domain.specialForecast.domain.repository.SpecialForecastRepository;
import com.heartForecast.domain.specialForecast.exception.SpecialForecastAlreadyExistsException;
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
