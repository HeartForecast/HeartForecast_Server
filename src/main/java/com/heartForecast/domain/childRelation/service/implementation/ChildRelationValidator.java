package com.heartForecast.domain.childRelation.service.implementation;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.childRelation.domain.repository.ChildRelationRepository;
import com.heartForecast.domain.childRelation.exception.DuplicateChildRelationException;
import com.heartForecast.domain.user.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChildRelationValidator {

  private final ChildRelationRepository childRelationRepository;

  public void existsByChildAndUser(Child child, Users user) {
    if (childRelationRepository.existsByChildAndUser(child, user)) throw new DuplicateChildRelationException();
  }
}
