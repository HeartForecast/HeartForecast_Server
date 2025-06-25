package com.heartForecast.domain.event.service.implementation;

import com.heartForecast.domain.event.domain.Event;
import com.heartForecast.domain.event.domain.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventDeleter {

  private final EventRepository eventRepository;

  public void delete(Event event) {
    eventRepository.delete(event);
  }
}
