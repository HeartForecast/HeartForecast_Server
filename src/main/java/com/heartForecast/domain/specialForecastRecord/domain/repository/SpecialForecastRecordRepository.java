package com.heartForecast.domain.specialForecastRecord.domain.repository;

import com.heartForecast.domain.specialForecastRecord.domain.SpecialForecastRecord;
import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.specialForecast.domain.SpecialForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecialForecastRecordRepository extends JpaRepository<SpecialForecastRecord, Long> {
  boolean existsBySpecialForecast(SpecialForecast specialForecast);
  Optional<SpecialForecastRecord> findByIdAndChild(Long id, Child child);
  List<SpecialForecastRecord> findAllByChildOrderByDateAsc(Child child);
  void deleteBySpecialForecast(SpecialForecast specialForecast);
}
