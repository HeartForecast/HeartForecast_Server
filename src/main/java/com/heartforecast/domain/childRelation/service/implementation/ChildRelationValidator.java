package com.heartforecast.domain.childRelation.service.implementation;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.childRelation.domain.repository.ChildRelationRepository;
import com.heartforecast.domain.childRelation.exception.DuplicateChildRelationException;
import com.heartforecast.domain.user.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChildRelationValidator {

  private final ChildRelationRepository childRelationRepository;

  public void validate(Child child, Users user) {
    if (childRelationRepository.existsByChildAndUser(child, user)) throw new DuplicateChildRelationException();
  }
}
