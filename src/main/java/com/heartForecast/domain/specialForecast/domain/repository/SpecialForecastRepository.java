package com.heartForecast.domain.specialForecast.domain.repository;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.event.domain.Event;
import com.heartForecast.domain.specialForecast.domain.SpecialForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecialForecastRepository extends JpaRepository<SpecialForecast, Long> {
  boolean existsByEvent(Event event);
  Optional<SpecialForecast> findByIdAndChild(Long id, Child child);
  List<SpecialForecast> findAllByChildOrderByDateAsc(Child child);
  Optional<SpecialForecast> findByEvent(Event event);
  void deleteByEvent(Event event);
}
