package com.heartforecast.domain.event.service;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.child.service.QueryChildService;
import com.heartforecast.domain.event.domain.Event;
import com.heartforecast.domain.event.presentation.dto.request.EventCreateRequest;
import com.heartforecast.domain.event.presentation.dto.request.EventUpdateRequest;
import com.heartforecast.domain.event.service.implementation.EventCreator;
import com.heartforecast.domain.event.service.implementation.EventDeleter;
import com.heartforecast.domain.event.service.implementation.EventUpdater;
import com.heartforecast.domain.user.domain.Users;
import com.heartforecast.domain.user.service.QueryUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandEventService {

  private final EventCreator eventCreator;
  private final EventUpdater eventUpdater;
  private final EventDeleter eventDeleter;
  private final QueryEventService queryEventService;
  private final QueryChildService queryChildService;
  private final QueryUserService queryUserService;

  public void create(EventCreateRequest request, Long userId) {
    Child child = queryChildService.readOne(request.childId());
    Users user = queryUserService.readOne(userId);

    Event event = Event.builder()
        .user(user)
        .child(child)
        .date(request.date())
        .title(request.title())
        .description(request.description())
        .build();
    eventCreator.create(event);
  }

  public void update(EventUpdateRequest request, Long userId) {
    Event event = queryEventService.findOneByUser(request.eventId(), userId);

    //특보 구현 후 특보 있을 시 예외 발생 로직 추가 예정

    eventUpdater.update(event, request.date(), request.title(), request.description());
  }

  public void delete(Long eventId, Long userId) {

    //특보 구현시 생성된 특보 삭제 로직 추가 예정

    eventDeleter.delete(queryEventService.findOneByUser(eventId, userId));
  }
}
