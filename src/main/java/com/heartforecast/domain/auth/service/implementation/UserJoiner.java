package com.heartforecast.domain.auth.service.implementation;

import com.heartforecast.domain.auth.presentation.dto.request.JoinUserRequest;
import com.heartforecast.domain.user.domain.Users;
import com.heartforecast.domain.user.domain.repository.UserRepository;
import com.heartforecast.domain.user.domain.value.Role;
import com.heartforecast.domain.user.exception.UserExistedException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserJoiner {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public void joinProcess(JoinUserRequest joinUserRequest) {
        String email = joinUserRequest.email();
        String password = joinUserRequest.password();

        Boolean isExist = userRepository.existsByEmail(email);

        if (isExist) throw new UserExistedException();

        Users user = Users.normalUserBuilder()
                .username(joinUserRequest.username())
                .type("normal")
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(Role.USER)
                .build();

        userRepository.save(user);
    }
}
