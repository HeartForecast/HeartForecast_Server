package com.heartForecast.domain.childRelation.presentation;

import com.heartForecast.domain.child.presentation.dto.response.ChildResponse;
import com.heartForecast.domain.childRelation.presentation.dto.request.ChildRelationJoinRequest;
import com.heartForecast.domain.childRelation.service.CommandChildRelationService;
import com.heartForecast.domain.childRelation.service.QueryChildRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.heartForecast.common.jwt.util.AuthenticationUtil.getMemberId;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "돌봄관계 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/childRelations")
public class ChildRelationController {

  private final CommandChildRelationService commandChildRelationService;
  private final QueryChildRelationService queryChildRelationService;

  @Operation(summary = "돌봄관계 등록", description = "초대코드를 통해 돌봄관계를 등록합니다.")
  @PostMapping("childRelation")
  public void joinChildRelation(@RequestBody ChildRelationJoinRequest request) {
    commandChildRelationService.join(request, getMemberId());
  }

  @Operation(summary = "특정 아이 돌봄관계 조회", description = "아이 ID를 통해 해당 아이의 돌봄관계를 조회합니다.")
  @GetMapping("/{child-id}")
  public ChildResponse getChildRelation(@PathVariable("child-id") Long childId) {
    return ChildResponse.from(queryChildRelationService.readOne(childId, getMemberId()));
  }

  @Operation(summary = "전체 돌봄관계 목록 조회", description = "현재 사용자의 모든 돌봄관계 목록을 조회합니다.")
  @GetMapping
  public List<ChildResponse> getChildRelations() {
    return queryChildRelationService.readAll(getMemberId()).stream()
        .map(ChildResponse::from)
        .toList();
  }

  @Operation(summary = "돌봄관계 삭제", description = "아이 ID를 통해 돌봄관계를 삭제합니다.")
  @DeleteMapping("/{child-id}")
  public void deleteChildRelation(@PathVariable("child-id") Long childId) {
    commandChildRelationService.delete(childId, getMemberId());
  }
}
