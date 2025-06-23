package com.heartforecast.domain.event.domain.repository;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.event.domain.Event;
import com.heartforecast.domain.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
  Optional<Event> findByIdAndUser(Long id, Users user);
  List<Event> findAllByChildAndUser(Child child, Users user);
}
