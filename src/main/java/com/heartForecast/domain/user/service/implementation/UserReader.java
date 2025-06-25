package com.heartForecast.domain.user.service.implementation;

import com.heartForecast.domain.user.domain.Users;
import com.heartForecast.domain.user.domain.repository.UserRepository;
import com.heartForecast.domain.user.exception.UserNotFoundException;
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
