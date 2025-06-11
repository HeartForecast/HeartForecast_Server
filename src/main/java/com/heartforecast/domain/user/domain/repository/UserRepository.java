package com.heartforecast.domain.user.domain.repository;

import com.heartforecast.domain.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
