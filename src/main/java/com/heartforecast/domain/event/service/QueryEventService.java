package com.heartforecast.domain.event.service;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.child.service.QueryChildService;
import com.heartforecast.domain.event.domain.Event;
import com.heartforecast.domain.event.service.implementation.EventReader;
import com.heartforecast.domain.user.domain.Users;
import com.heartforecast.domain.user.service.QueryUserService;
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
