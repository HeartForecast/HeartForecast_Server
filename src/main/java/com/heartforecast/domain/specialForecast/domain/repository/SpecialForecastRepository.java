package com.heartforecast.domain.specialForecast.domain.repository;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.event.domain.Event;
import com.heartforecast.domain.specialForecast.domain.SpecialForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecialForecastRepository extends JpaRepository<SpecialForecast, Long> {
  boolean existsByEvent(Event event);
  Optional<SpecialForecast> findByIdAndChild(Long id, Child child);
}
