package com.heartForecast.domain.child.service;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.child.presentation.dto.request.ChildCreateRequest;
import com.heartForecast.domain.child.presentation.dto.request.ChildUpdateRequest;
import com.heartForecast.domain.child.service.implementation.ChildCreator;
import com.heartForecast.domain.child.service.implementation.ChildDeleter;
import com.heartForecast.domain.childRelation.domain.ChildRelation;
import com.heartForecast.domain.childRelation.service.QueryChildRelationService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandChildService {

  private final ChildCreator childCreator;
  private final ChildDeleter childDeleter;
  private final QueryChildService queryChildService;
  private final QueryChildRelationService queryChildRelationService;

  public Child create(ChildCreateRequest request) {
    Child child = Child.builder()
        .username(request.username())
        .birthdate(request.birthdate())
        .gender(request.gender())
        .healthInfo(request.healthInfo())
        .inviteCode(RandomStringUtils.randomNumeric(6))
        .build();
    return childCreator.create(child);
  }

  public void update(ChildUpdateRequest request, Long userId) {
    ChildRelation childRelation = queryChildRelationService.readOne(request.childId(), userId);
    childRelation.getChild().update(request.username(), request.birthdate(), request.gender(), request.healthInfo());
  }

  public void delete(Long childId) {
    childDeleter.delete(queryChildService.readOne(childId));
  }
}
