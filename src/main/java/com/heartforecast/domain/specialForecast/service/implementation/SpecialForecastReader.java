package com.heartforecast.domain.specialForecast.service.implementation;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.event.domain.Event;
import com.heartforecast.domain.specialForecast.domain.SpecialForecast;
import com.heartforecast.domain.specialForecast.domain.repository.SpecialForecastRepository;
import com.heartforecast.domain.specialForecast.exception.SpecialForecastNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialForecastReader {

  private final SpecialForecastRepository specialForecastRepository;

  public SpecialForecast findByIdAndChild(Long id, Child child) {
    return specialForecastRepository.findByIdAndChild(id, child)
        .orElseThrow(SpecialForecastNotFoundException::new);
  }

  public List<SpecialForecast> findAllByChild(Child child) {
    return specialForecastRepository.findAllByChild(child);
  }

  public SpecialForecast findByEvent(Event event) {
    return specialForecastRepository.findByEvent(event)
        .orElseThrow(SpecialForecastNotFoundException::new);
  }
}
