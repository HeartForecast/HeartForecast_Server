package com.heartforecast.domain.event.service.implementation;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.event.domain.Event;
import com.heartforecast.domain.event.domain.repository.EventRepository;
import com.heartforecast.domain.event.exception.EventNotFoundException;
import com.heartforecast.domain.user.domain.Users;
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

  public List<Event> findAllByChildAndUser(Child child, Users user) {
    return eventRepository.findAllByChildAndUser(child, user);
  }
}
