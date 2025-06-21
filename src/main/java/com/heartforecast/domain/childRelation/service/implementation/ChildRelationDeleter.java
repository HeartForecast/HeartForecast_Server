package com.heartforecast.domain.childRelation.service.implementation;

import com.heartforecast.domain.childRelation.domain.ChildRelation;
import com.heartforecast.domain.childRelation.domain.repository.ChildRelationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChildRelationDeleter {

  private final ChildRelationRepository childRelationRepository;

  public void delete(ChildRelation childRelation) {
    childRelationRepository.delete(childRelation);
  }
}
