package com.heartForecast.domain.user.service;

import com.heartForecast.domain.user.domain.Users;
import com.heartForecast.domain.user.service.implementation.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryUserService {

  private final UserReader userReader;

  public Users readOne(Long id) {
    return userReader.findById(id);
  }
}
