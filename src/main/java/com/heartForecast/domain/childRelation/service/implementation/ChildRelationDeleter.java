package com.heartForecast.domain.childRelation.service.implementation;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.childRelation.domain.ChildRelation;
import com.heartForecast.domain.childRelation.domain.repository.ChildRelationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChildRelationDeleter {

  private final ChildRelationRepository childRelationRepository;

  public void delete(ChildRelation childRelation) {
    childRelationRepository.delete(childRelation);
  }

  public void deleteAll(Child child) {
    childRelationRepository.deleteAllByChild(child);
  }
}
