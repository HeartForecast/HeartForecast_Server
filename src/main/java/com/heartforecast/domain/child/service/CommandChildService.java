package com.heartforecast.domain.child.service;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.childRelation.presentation.dto.request.ChildCreateRequest;
import com.heartforecast.domain.childRelation.presentation.dto.request.ChildUpdateHealthRequest;
import com.heartforecast.domain.child.service.implementation.ChildCreator;
import com.heartforecast.domain.child.service.implementation.ChildDeleter;
import com.heartforecast.domain.child.service.implementation.ChildReader;
import com.heartforecast.domain.child.service.implementation.ChildUpdater;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandChildService {

  private final ChildCreator childCreator;
  private final ChildReader childReader;
  private final ChildUpdater childUpdater;
  private final ChildDeleter childDeleter;

  public Child create(ChildCreateRequest request) {
    Child child = Child.builder()
        .username(request.username())
        .birthdate(request.birthdate())
        .gender(request.gender())
        .healthInfo(request.healthInfo())
        .inviteCode(RandomStringUtils.randomAlphanumeric(6))
        .build();
    return childCreator.create(child);
  }

  public void updateHealth(ChildUpdateHealthRequest request) {
    Child child = childReader.findById(request.childId());
    childUpdater.updateHealthInfo(child, request.healthInfo());
  }

  public void delete(Long id) {
    Child child = childReader.findById(id);
    childDeleter.delete(child);
  }
}
