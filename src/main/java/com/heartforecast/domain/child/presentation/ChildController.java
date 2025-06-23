package com.heartforecast.domain.child.presentation;

import com.heartforecast.domain.child.presentation.dto.request.ChildCreateRequest;
import com.heartforecast.domain.child.presentation.dto.request.ChildUpdateRequest;
import com.heartforecast.domain.child.service.CommandChildService;
import com.heartforecast.domain.childRelation.service.CommandChildRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.heartforecast.common.jwt.util.AuthenticationUtil.getMemberId;

@RestController
@RequiredArgsConstructor
@RequestMapping("/children")
public class ChildController {

  private final CommandChildService commandChildService;
  private final CommandChildRelationService commandChildRelationService;

  @PostMapping("/child")
  public void createChild(@RequestBody ChildCreateRequest request) {
    commandChildRelationService.create(request, getMemberId());
  }

  @PutMapping("/child")
  public void updateChild(@RequestBody ChildUpdateRequest request) {
    commandChildService.update(request, getMemberId());
  }

  @DeleteMapping("/{child-id}")
  public void deleteChild(@PathVariable("child-id") Long childId) {
    commandChildRelationService.deleteAll(childId, getMemberId());
    commandChildService.delete(childId);
  }
}
