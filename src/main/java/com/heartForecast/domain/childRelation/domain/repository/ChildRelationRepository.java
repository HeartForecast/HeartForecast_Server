package com.heartForecast.domain.childRelation.domain.repository;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.childRelation.domain.ChildRelation;
import com.heartForecast.domain.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChildRelationRepository extends JpaRepository<ChildRelation, Long> {
  Optional<ChildRelation> findByUserAndChild(Users user, Child child);
  List<ChildRelation> findByUser(Users user);
  void deleteAllByChild(Child child);
  boolean existsByChild(Child child);
  boolean existsByChildAndUser(Child child, Users user);
}
