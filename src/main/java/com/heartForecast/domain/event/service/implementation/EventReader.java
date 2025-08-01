package com.heartForecast.domain.event.service.implementation;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.event.domain.Event;
import com.heartForecast.domain.event.domain.repository.EventRepository;
import com.heartForecast.domain.event.exception.EventNotFoundException;
import com.heartForecast.domain.user.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventReader {

  private final EventRepository eventRepository;

  public Event findByIdAndUser(Long id, Users user) {
    return eventRepository.findByIdAndUser(id, user)
        .orElseThrow(EventNotFoundException::new);
  }

  public Event findByIdAndChild(Long id, Child child) {
    return eventRepository.findByIdAndChild(id, child)
        .orElseThrow(EventNotFoundException::new);
  }

  public List<Event> findAllByChildAndUser(Child child, Users user) {
    return eventRepository.findAllByChildAndUser(child, user);
  }
}
