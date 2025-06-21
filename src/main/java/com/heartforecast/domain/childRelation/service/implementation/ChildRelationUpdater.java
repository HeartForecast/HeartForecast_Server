package com.heartforecast.domain.childRelation.service.implementation;

import com.heartforecast.domain.childRelation.domain.ChildRelation;
import org.springframework.stereotype.Service;

@Service
public class ChildRelationUpdater {

  public void update(ChildRelation childRelation, String role) {
    childRelation.updateRole(role);
  }
}
