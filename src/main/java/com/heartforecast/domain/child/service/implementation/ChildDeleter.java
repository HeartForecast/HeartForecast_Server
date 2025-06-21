package com.heartforecast.domain.child.service.implementation;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.child.domain.repository.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChildDeleter {

  private final ChildRepository childRepository;

  public void delete(Child child) {
    childRepository.delete(child);
  }
}
