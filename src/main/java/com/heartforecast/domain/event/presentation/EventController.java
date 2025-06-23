package com.heartforecast.domain.event.presentation;

import com.heartforecast.domain.event.presentation.dto.request.EventCreateRequest;
import com.heartforecast.domain.event.service.CommandEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.heartforecast.common.jwt.util.AuthenticationUtil.getMemberId;

@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {

  public final CommandEventService commandEventService;

  @PostMapping
  public void createEvent(@RequestBody EventCreateRequest request) {
    commandEventService.create(request, getMemberId());
  }
}
