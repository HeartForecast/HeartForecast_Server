package com.heartforecast.domain.childRelation.domain.repository;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.childRelation.domain.ChildRelation;
import com.heartforecast.domain.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChildRelationRepository extends JpaRepository<ChildRelation, Long> {
  Optional<ChildRelation> findByUserAndChild(Users user, Child child);
  List<ChildRelation> findByUser(Users user);
}
