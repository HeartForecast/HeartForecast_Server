package com.heartForecast.domain.child.presentation;

import com.heartForecast.domain.child.presentation.dto.request.ChildCreateRequest;
import com.heartForecast.domain.child.presentation.dto.request.ChildUpdateRequest;
import com.heartForecast.domain.child.service.CommandChildService;
import com.heartForecast.domain.childRelation.service.CommandChildRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.heartForecast.common.jwt.util.AuthenticationUtil.getMemberId;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "아이 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/children")
public class ChildController {

  private final CommandChildService commandChildService;
  private final CommandChildRelationService commandChildRelationService;

  @Operation(summary = "아이 생성", description = "새로운 아이를 생성하고 현재 유저의 연관관계로 저장합니다.")
  @PostMapping("/child")
  public void createChild(@RequestBody ChildCreateRequest request) {
    commandChildRelationService.create(request, getMemberId());
  }

  @Operation(summary = "아이 정보 수정", description = "아이의 정보를 변경합니다.")
  @PutMapping("/child")
  public void updateChild(@RequestBody ChildUpdateRequest request) {
    commandChildService.update(request, getMemberId());
  }

  @Operation(summary = "아이 삭제", description = "아이를 삭제하고 연관된 데이터를 모두 제거합니다.")
  @DeleteMapping("/{child-id}")
  public void deleteChild(@PathVariable("child-id") Long childId) {
    commandChildRelationService.deleteAll(childId, getMemberId());
    commandChildService.delete(childId);
  }
}


