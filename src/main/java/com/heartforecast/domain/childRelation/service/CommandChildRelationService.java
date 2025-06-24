package com.heartforecast.domain.childRelation.service;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.child.presentation.dto.request.ChildCreateRequest;
import com.heartforecast.domain.child.service.CommandChildService;
import com.heartforecast.domain.child.service.QueryChildService;
import com.heartforecast.domain.childRelation.domain.ChildRelation;
import com.heartforecast.domain.childRelation.presentation.dto.request.ChildRelationJoinRequest;
import com.heartforecast.domain.childRelation.presentation.dto.request.ChildRelationUpdateRequest;
import com.heartforecast.domain.childRelation.service.implementation.ChildRelationCreator;
import com.heartforecast.domain.childRelation.service.implementation.ChildRelationDeleter;
import com.heartforecast.domain.childRelation.service.implementation.ChildRelationUpdater;
import com.heartforecast.domain.childRelation.service.implementation.ChildRelationValidator;
import com.heartforecast.domain.user.domain.Users;
import com.heartforecast.domain.user.service.QueryUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandChildRelationService {

  private final ChildRelationCreator childRelationCreator;
  private final ChildRelationUpdater childRelationUpdater;
  private final ChildRelationDeleter childRelationDeleter;
  private final ChildRelationValidator childRelationValidator;
  private final CommandChildService commandChildService;
  private final QueryChildRelationService queryChildRelationService;
  private final QueryChildService queryChildService;
  private final QueryUserService queryUserService;


  public void create(ChildCreateRequest request, Long userId) {
    Child child = commandChildService.create(request);
    Users user = queryUserService.readOne(userId);

    ChildRelation childRelation = ChildRelation.builder()
        .child(child)
        .user(user)
        .role(request.role())
        .build();
    childRelationCreator.create(childRelation);
  }

  public void join(ChildRelationJoinRequest request, Long userId) {
    Child child = queryChildService.findInviteCode(request.inviteCode());
    Users user = queryUserService.readOne(userId);

    childRelationValidator.existsByChildAndUser(child, user);

    ChildRelation childRelation = ChildRelation.builder()
        .child(child)
        .user(user)
        .role(request.role())
        .build();
    childRelationCreator.create(childRelation);
  }

  public void update(ChildRelationUpdateRequest request, Long userId) {
    childRelationUpdater.update(queryChildRelationService.readOne(request.childId(), userId), request.role());
  }

  public void delete(Long childId, Long userId) {
    childRelationDeleter.delete(queryChildRelationService.readOne(childId, userId));

    if (!queryChildRelationService.existsRelation(childId)) commandChildService.delete(childId);
  }

  public void deleteAll(Long childId, Long userId) {
    childRelationDeleter.deleteAll(queryChildRelationService.readOne(childId, userId).getChild());
  }
}
