package com.heartforecast.domain.childRelation.service.implementation;

import com.heartforecast.domain.childRelation.domain.ChildRelation;
import com.heartforecast.domain.childRelation.domain.repository.ChildRelationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChildRelationCreator {

  private final ChildRelationRepository childRelationRepository;

  public void create(ChildRelation childRelation) {
    childRelationRepository.save(childRelation);
  }
}
