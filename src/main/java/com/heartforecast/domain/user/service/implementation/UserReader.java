package com.heartforecast.domain.user.service.implementation;

import com.heartforecast.domain.user.domain.Users;
import com.heartforecast.domain.user.domain.repository.UserRepository;
import com.heartforecast.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserReader {

  private final UserRepository userRepository;

  public Users findById(Long id) {
    return userRepository.findById(id)
        .orElseThrow(UserNotFoundException::new);
  }
}
