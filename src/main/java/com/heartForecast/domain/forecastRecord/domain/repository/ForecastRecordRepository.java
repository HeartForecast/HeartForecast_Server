package com.heartForecast.domain.forecastRecord.domain.repository;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.forecast.domain.Forecast;
import com.heartForecast.domain.forecastRecord.domain.ForecastRecord;
import com.heartForecast.domain.statistic.presentation.dto.response.DateTempResponse;
import com.heartForecast.domain.statistic.presentation.dto.response.TimeZoneEmotionCountResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ForecastRecordRepository extends JpaRepository<ForecastRecord, Long> {
  Optional<ForecastRecord> findByIdAndChild(Long id, Child child);
  List<ForecastRecord> findByChild(Child child);
  List<ForecastRecord> findByDateAndChild(LocalDate date, Child child);
  void deleteAllByChild(Child child);
  boolean existsByForecast(Forecast forecast);
  @Query("SELECT new com.heartForecast.domain.statistic.presentation.dto.response.DateTempResponse(fr.date, AVG(fr.emotionType.temp)) " +
      "FROM ForecastRecord fr " +
      "WHERE fr.child = :child AND fr.date BETWEEN :startDate AND :endDate " +
      "GROUP BY fr.date ORDER BY fr.date")
  List<DateTempResponse> findDailyAverageTemperature(@Param("child") Child child,
                                                     @Param("startDate") LocalDate startDate,
                                                     @Param("endDate") LocalDate endDate);

  @Query("""
    SELECT new com.heartForecast.domain.statistic.presentation.dto.response.TimeZoneEmotionCountResponse(
        fr.timeZone,
        fr.emotionType.name,
        COUNT(fr)
    )
    FROM ForecastRecord fr
    WHERE fr.child = :child
    AND fr.date BETWEEN :startDate AND :endDate
    GROUP BY fr.timeZone, fr.emotionType.name
    ORDER BY fr.timeZone
    """)
  List<TimeZoneEmotionCountResponse> findEmotionCountByTimeZone(
      @Param("child") Child child,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate
  );

  @Query("""
    SELECT fr.emotionType.name, COUNT(fr)
    FROM ForecastRecord fr
    WHERE fr.child = :child
      AND fr.date BETWEEN :startDate AND :endDate
    GROUP BY fr.emotionType.name
    """)
  List<Object[]> countEmotionsByNameInPeriod(
      @Param("child") Child child,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate
  );

  @Query("""
    SELECT AVG(et.temp)
    FROM ForecastRecord fr
    JOIN EmotionType et ON fr.emotionType = et
    WHERE fr.child = :child
    AND fr.date BETWEEN :startDate AND :endDate
    """)
  Double findAverageTemperatureByChildAndDateRange(
      @Param("child") Child child,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate
  );
}
