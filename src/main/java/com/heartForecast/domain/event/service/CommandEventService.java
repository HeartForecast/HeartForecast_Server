package com.heartForecast.domain.event.service;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.child.service.QueryChildService;
import com.heartForecast.domain.event.domain.Event;
import com.heartForecast.domain.event.presentation.dto.request.EventCreateRequest;
import com.heartForecast.domain.event.presentation.dto.request.EventUpdateRequest;
import com.heartForecast.domain.event.service.implementation.EventCreator;
import com.heartForecast.domain.event.service.implementation.EventDeleter;
import com.heartForecast.domain.event.service.implementation.EventUpdater;
import com.heartForecast.domain.specialForecast.service.CommandSpecialForecastService;
import com.heartForecast.domain.specialForecast.service.implementation.SpecialForecastValidator;
import com.heartForecast.domain.user.domain.Users;
import com.heartForecast.domain.user.service.QueryUserService;
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
  private final SpecialForecastValidator specialForecastValidator;
  private final CommandSpecialForecastService commandSpecialForecastService;

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

    specialForecastValidator.existsByEvent(event);

    eventUpdater.update(event, request.date(), request.title(), request.description());
  }

  public void delete(Long eventId, Long userId) {
    commandSpecialForecastService.deleteByEvent(eventId, userId);
    eventDeleter.delete(queryEventService.findOneByUser(eventId, userId));
  }
}
