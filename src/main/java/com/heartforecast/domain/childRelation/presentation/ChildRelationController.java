package com.heartforecast.domain.childRelation.presentation;

import com.heartforecast.domain.child.presentation.dto.response.ChildResponse;
import com.heartforecast.domain.childRelation.domain.ChildRelation;
import com.heartforecast.domain.childRelation.presentation.dto.request.ChildRelationJoinRequest;
import com.heartforecast.domain.childRelation.presentation.dto.request.ChildRelationUpdateRequest;
import com.heartforecast.domain.childRelation.presentation.dto.response.ChildRelationResponse;
import com.heartforecast.domain.childRelation.service.CommandChildRelationService;
import com.heartforecast.domain.childRelation.service.QueryChildRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.heartforecast.common.jwt.util.AuthenticationUtil.getMemberId;
import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/childRelations")
public class ChildRelationController {

  private final CommandChildRelationService commandChildRelationService;
  private final QueryChildRelationService queryChildRelationService;

  @PostMapping("childRelation")
  public void joinChildRelation(@RequestBody ChildRelationJoinRequest request) {
    commandChildRelationService.join(request, getMemberId());
  }

  @GetMapping("/{child-id}")
  public ChildRelationResponse getChildRelation(@PathVariable("child-id") Long childId) {
    ChildRelation relation = queryChildRelationService.readOne(childId, getMemberId());
    return ChildRelationResponse.of(
        ChildResponse.from(relation.getChild()),
        relation.getRole()
    );
  }

  @GetMapping
  public List<ChildRelationResponse> getChildRelations() {
    return queryChildRelationService.readAll(getMemberId()).stream()
        .map(relation -> ChildRelationResponse.of(
            ChildResponse.from(relation.getChild()),
            relation.getRole()
        ))
        .collect(toList());
  }

  @PutMapping("childRelation")
  public void updateChildRelation(@RequestBody ChildRelationUpdateRequest request) {
    commandChildRelationService.update(request, getMemberId());
  }

  @DeleteMapping("/{child-id}")
  public void deleteChildRelation(@PathVariable("child-id") Long childId) {
    commandChildRelationService.delete(childId, getMemberId());
  }
}
