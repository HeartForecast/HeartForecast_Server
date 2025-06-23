package com.heartforecast.domain.event.presentation;

import com.heartforecast.domain.event.domain.Event;
import com.heartforecast.domain.event.presentation.dto.request.EventCreateRequest;
import com.heartforecast.domain.event.presentation.dto.request.EventUpdateRequest;
import com.heartforecast.domain.event.presentation.dto.response.EventResponse;
import com.heartforecast.domain.event.service.CommandEventService;
import com.heartforecast.domain.event.service.QueryEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.heartforecast.common.jwt.util.AuthenticationUtil.getMemberId;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {

  public final CommandEventService commandEventService;
  public final QueryEventService queryEventService;

  @PostMapping("/event")
  public void createEvent(@RequestBody EventCreateRequest request) {
    commandEventService.create(request, getMemberId());
  }

  @GetMapping("/{child-id}/{event-id}")
  public EventResponse getEvent(
      @PathVariable("child-id") Long childId,
      @PathVariable("event-id") Long eventId) {
    Event event = queryEventService.findOneByUser(eventId, getMemberId());
    return EventResponse.from(
        event.getId(),
        childId,
        event.getDate(),
        event.getTitle(),
        event.getDescription()
    );
  }

  @GetMapping("/{child-id}")
  public List<EventResponse> getEvents(@PathVariable("child-id") Long childId) {
    List<Event> events = queryEventService.readAll(childId, getMemberId());
    return events.stream()
        .map(event -> EventResponse.from(
            event.getId(),
            event.getChild().getId(),
            event.getDate(),
            event.getTitle(),
            event.getDescription()
        ))
        .toList();
  }

  @PutMapping("/event")
  public void updateEvent(@RequestBody EventUpdateRequest request) {
    commandEventService.update(request, getMemberId());
  }

  @DeleteMapping("/{event-id}")
  public void deleteEvent(@PathVariable("event-id") Long eventId) {
    commandEventService.delete(eventId, getMemberId());
  }
}