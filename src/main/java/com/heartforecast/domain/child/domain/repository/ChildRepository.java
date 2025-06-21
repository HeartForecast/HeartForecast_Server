package com.heartforecast.domain.child.domain.repository;

import com.heartforecast.domain.child.domain.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {
  Optional<Child> findByInviteCode(String inviteCode);
}
