package com.heartforecast.domain.child.domain.repository;

import com.heartforecast.domain.child.domain.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChildRepository extends JpaRepository<Child, Long> {
  Optional<Child> findByInviteCode(String inviteCode);
}
