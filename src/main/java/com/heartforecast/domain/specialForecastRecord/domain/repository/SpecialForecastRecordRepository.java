package com.heartforecast.domain.specialForecastRecord.domain.repository;

import com.heartforecast.domain.specialForecastRecord.domain.SpecialForecastRecord;
import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.specialForecast.domain.SpecialForecast;
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
