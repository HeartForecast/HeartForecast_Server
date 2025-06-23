package com.heartforecast.domain.event.service.implementation;

import com.heartforecast.domain.event.domain.Event;
import com.heartforecast.domain.event.domain.repository.EventRepository;
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
