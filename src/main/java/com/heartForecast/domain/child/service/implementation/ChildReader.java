package com.heartForecast.domain.child.service.implementation;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.child.domain.repository.ChildRepository;
import com.heartForecast.domain.child.exception.ChildNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChildReader {

  private final ChildRepository childRepository;

  public Child findById(Long id) {
    return childRepository.findById(id)
        .orElseThrow(ChildNotFoundException::new);
  }

  public Child findByInviteCode(String inviteCode) {
    return childRepository.findByInviteCode(inviteCode)
        .orElseThrow(ChildNotFoundException::new);
  }
}
