package com.heartForecast.domain.childRelation.service;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.child.presentation.dto.request.ChildCreateRequest;
import com.heartForecast.domain.child.service.CommandChildService;
import com.heartForecast.domain.child.service.QueryChildService;
import com.heartForecast.domain.childRelation.domain.ChildRelation;
import com.heartForecast.domain.childRelation.presentation.dto.request.ChildRelationJoinRequest;
import com.heartForecast.domain.childRelation.service.implementation.ChildRelationCreator;
import com.heartForecast.domain.childRelation.service.implementation.ChildRelationDeleter;
import com.heartForecast.domain.childRelation.service.implementation.ChildRelationValidator;
import com.heartForecast.domain.forecast.service.CommandForecastService;
import com.heartForecast.domain.forecastRecord.service.CommandForecastRecordService;
import com.heartForecast.domain.user.domain.Users;
import com.heartForecast.domain.user.service.QueryUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandChildRelationService {

  private final ChildRelationCreator childRelationCreator;
  private final ChildRelationDeleter childRelationDeleter;
  private final ChildRelationValidator childRelationValidator;
  private final CommandChildService commandChildService;
  private final QueryChildRelationService queryChildRelationService;
  private final QueryChildService queryChildService;
  private final QueryUserService queryUserService;
  private final CommandForecastService commandForecastService;
  private final CommandForecastRecordService commandForecastRecordService;

  public void create(ChildCreateRequest request, Long userId) {
    Child child = commandChildService.create(request);
    Users user = queryUserService.readOne(userId);

    ChildRelation childRelation = ChildRelation.builder()
        .child(child)
        .user(user)
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
        .build();
    childRelationCreator.create(childRelation);
  }

  public void delete(Long childId, Long userId) {
    childRelationDeleter.delete(queryChildRelationService.readOne(childId, userId));

    if (!queryChildRelationService.existsRelation(childId)) {
      commandForecastRecordService.deleteAll(childId);
      commandForecastService.deleteAll(childId);
      commandChildService.delete(childId);
    }
  }

  public void deleteAll(Long childId, Long userId) {
    childRelationDeleter.deleteAll(queryChildRelationService.readOne(childId, userId).getChild());
  }
}
