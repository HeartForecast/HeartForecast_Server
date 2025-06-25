package com.heartForecast.domain.childRelation.service.implementation;

import com.heartForecast.domain.childRelation.domain.ChildRelation;
import org.springframework.stereotype.Service;

@Service
public class ChildRelationUpdater {

  public void update(ChildRelation childRelation, String role) {
    childRelation.updateRole(role);
  }
}
