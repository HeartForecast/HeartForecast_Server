package com.heartForecast.domain.event.service.implementation;

import com.heartForecast.domain.event.domain.Event;
import com.heartForecast.domain.event.domain.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventCreator {

  private final EventRepository eventRepository;

  public void create(Event event) {
    eventRepository.save(event);
  }
}
