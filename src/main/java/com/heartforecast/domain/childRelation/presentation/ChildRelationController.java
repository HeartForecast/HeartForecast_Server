package com.heartforecast.domain.childRelation.presentation;

import com.heartforecast.domain.child.presentation.dto.request.ChildCreateRequest;
import com.heartforecast.domain.childRelation.service.CommandChildRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.heartforecast.common.jwt.util.AuthenticationUtil.getMemberId;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/child")
public class ChildRelationController {

  private final CommandChildRelationService commandChildRelationService;

  @PostMapping
  public void createChild(@RequestBody ChildCreateRequest request) {
    commandChildRelationService.createChildRelation(request, getMemberId());
  }
}
