package com.heartForecast.domain.childRelation.service.implementation;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.childRelation.domain.ChildRelation;
import com.heartForecast.domain.childRelation.domain.repository.ChildRelationRepository;
import com.heartForecast.domain.childRelation.exception.ChildRelationNotFoundException;
import com.heartForecast.domain.user.domain.Users;
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

  public boolean existsByChild(Child child) {
    return childRelationRepository.existsByChild(child);
  }
}
