package com.heartforecast.domain.childRelation.service;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.child.presentation.dto.request.ChildCreateRequest;
import com.heartforecast.domain.child.service.CommandChildService;
import com.heartforecast.domain.childRelation.domain.ChildRelation;
import com.heartforecast.domain.childRelation.service.implementation.ChildRelationCreator;
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
  private final CommandChildService commandChildService;
  private final QueryUserService queryUserService;


  public void createChildRelation(ChildCreateRequest request, Long userId) {
    Child child = commandChildService.create(request);
    Users user = queryUserService.findOne(userId);

    ChildRelation childRelation = ChildRelation.builder()
        .child(child)
        .user(user)
        .role(request.role())
        .build();
    childRelationCreator.create(childRelation);
  }
}
