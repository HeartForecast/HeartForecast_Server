package com.heartforecast.domain.event.service.implementation;

import com.heartforecast.domain.event.domain.Event;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EventUpdater {

  public void update(Event event, LocalDate date, String title, String description) {
    event.update(date, title, description);
  }
}
