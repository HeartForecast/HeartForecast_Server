package com.heartForecast.domain.event.service;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.child.service.QueryChildService;
import com.heartForecast.domain.event.domain.Event;
import com.heartForecast.domain.event.service.implementation.EventReader;
import com.heartForecast.domain.user.domain.Users;
import com.heartForecast.domain.user.service.QueryUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryEventService {

  private final EventReader eventReader;
  private final QueryChildService queryChildService;
  private final QueryUserService queryUserService;

  public Event findOneByUser(Long eventId, Long userId) {
    Users user = queryUserService.readOne(userId);

    return eventReader.findByIdAndUser(eventId, user);
  }

  public Event findOneByChild(Long eventId, Long childId) {
    Child child = queryChildService.readOne(childId);

    return eventReader.findByIdAndChild(eventId, child);
  }

  public List<Event> readAll(Long childId, Long userId) {
    Child child = queryChildService.readOne(childId);
    Users user = queryUserService.readOne(userId);

    return eventReader.findAllByChildAndUser(child, user);
  }
}
