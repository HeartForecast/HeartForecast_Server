package com.heartforecast.domain.child.service.implementation;

import com.heartforecast.domain.child.domain.Child;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChildUpdater {

  public void updateHealthInfo(Child child, String healthInfo) {
    child.updateHealthInfo(healthInfo);
  }
}
