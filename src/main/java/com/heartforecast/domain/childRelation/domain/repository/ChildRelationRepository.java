package com.heartforecast.domain.childRelation.domain.repository;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.childRelation.domain.ChildRelation;
import com.heartforecast.domain.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRelationRepository extends JpaRepository<ChildRelation, Long> {
  boolean existsByUserAndChild(Users user, Child child);
}
