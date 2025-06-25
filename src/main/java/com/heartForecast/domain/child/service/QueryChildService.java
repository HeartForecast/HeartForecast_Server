package com.heartForecast.domain.child.service;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.child.service.implementation.ChildReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryChildService {

  private final ChildReader childReader;

  public Child readOne(Long id) {
    return childReader.findById(id);
  }

  public Child findInviteCode(String inviteCode) {
    return childReader.findByInviteCode(inviteCode);
  }
}
