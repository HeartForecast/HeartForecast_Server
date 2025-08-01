package com.heartForecast.domain.childRelation.service;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.child.service.QueryChildService;
import com.heartForecast.domain.childRelation.domain.ChildRelation;
import com.heartForecast.domain.childRelation.service.implementation.ChildRelationReader;
import com.heartForecast.domain.user.domain.Users;
import com.heartForecast.domain.user.service.QueryUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryChildRelationService {

  private final ChildRelationReader childRelationReader;
  private final QueryChildService queryChildService;
  private final QueryUserService queryUserService;

  public ChildRelation readOne(Long childId, Long userId) {
    Child child = queryChildService.readOne(childId);
    Users user = queryUserService.readOne(userId);

    return childRelationReader.findByUserAndChild(child, user);
  }

  public List<ChildRelation> readAll(Long userId) {
    return childRelationReader.findByUser(queryUserService.readOne(userId));
  }

  public boolean existsRelation(Long childId) {
    return childRelationReader.existsByChild(queryChildService.readOne(childId));
  }
}
