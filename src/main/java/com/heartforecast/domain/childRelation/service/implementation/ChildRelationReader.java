package com.heartforecast.domain.childRelation.service.implementation;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.childRelation.domain.ChildRelation;
import com.heartforecast.domain.childRelation.domain.repository.ChildRelationRepository;
import com.heartforecast.domain.childRelation.exception.ChildRelationNotFoundException;
import com.heartforecast.domain.user.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChildRelationReader {

  private final ChildRelationRepository childRelationRepository;

  public ChildRelation findByUserAndChild(Child child, Users user) {
    return childRelationRepository.findByUserAndChild(user, child)
        .orElseThrow(ChildRelationNotFoundException::new);
  }

  public List<ChildRelation> findByUser(Users user) {
    return childRelationRepository.findByUser(user);
  }
}
