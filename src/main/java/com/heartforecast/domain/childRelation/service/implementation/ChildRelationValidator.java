package com.heartforecast.domain.childRelation.service.implementation;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.childRelation.domain.repository.ChildRelationRepository;
import com.heartforecast.domain.childRelation.exception.ChildRelationFoundException;
import com.heartforecast.domain.user.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChildRelationValidator {

  private final ChildRelationRepository childRelationRepository;

  public void validate(Users user, Child child) {
    boolean exists = childRelationRepository.existsByUserAndChild(user, child);
    if (!exists) throw new ChildRelationFoundException();
  }
}
