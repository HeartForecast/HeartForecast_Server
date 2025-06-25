package com.heartForecast.domain.event.presentation;

import com.heartForecast.domain.event.domain.Event;
import com.heartForecast.domain.event.presentation.dto.request.EventCreateRequest;
import com.heartForecast.domain.event.presentation.dto.request.EventUpdateRequest;
import com.heartForecast.domain.event.presentation.dto.response.EventResponse;
import com.heartForecast.domain.event.service.CommandEventService;
import com.heartForecast.domain.event.service.QueryEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.heartForecast.common.jwt.util.AuthenticationUtil.getMemberId;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "이벤트 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {

  public final CommandEventService commandEventService;
  public final QueryEventService queryEventService;

  @Operation(summary = "이벤트 생성", description = "특정 아이에 대해 새로운 이벤트를 생성합니다.")
  @PostMapping("/event")
  public void createEvent(@RequestBody EventCreateRequest request) {
    commandEventService.create(request, getMemberId());
  }

  @Operation(summary = "이벤트 단일 조회", description = "아이 ID와 이벤트 ID로 특정 이벤트 정보를 조회합니다.")
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

  @Operation(summary = "아이 이벤트 목록 조회", description = "특정 아이의 모든 이벤트 목록을 조회합니다.")
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

  @Operation(summary = "이벤트 수정", description = "이벤트 정보를 수정합니다.")
  @PutMapping("/event")
  public void updateEvent(@RequestBody EventUpdateRequest request) {
    commandEventService.update(request, getMemberId());
  }

  @Operation(summary = "이벤트 삭제", description = "이벤트 ID로 특정 이벤트를 삭제합니다.")
  @DeleteMapping("/{event-id}")
  public void deleteEvent(@PathVariable("event-id") Long eventId) {
    commandEventService.delete(eventId, getMemberId());
  }
}