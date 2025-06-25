package com.heartForecast.domain.event.domain.repository;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.event.domain.Event;
import com.heartForecast.domain.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
  Optional<Event> findByIdAndUser(Long id, Users user);
  Optional<Event> findByIdAndChild(Long id, Child child);
  List<Event> findAllByChildAndUser(Child child, Users user);
}
