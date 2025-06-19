package com.heartforecast.domain.user.service;

import com.heartforecast.domain.user.domain.Users;
import com.heartforecast.domain.user.service.implementation.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryUserService {

  private final UserReader userReader;

  public Users findOne(Long id) {
    return userReader.findById(id);
  }
}
