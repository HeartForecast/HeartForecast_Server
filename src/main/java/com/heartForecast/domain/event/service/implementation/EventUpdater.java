package com.heartForecast.domain.event.service.implementation;

import com.heartForecast.domain.event.domain.Event;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EventUpdater {

  public void update(Event event, LocalDate date, String title, String description) {
    event.update(date, title, description);
  }
}
