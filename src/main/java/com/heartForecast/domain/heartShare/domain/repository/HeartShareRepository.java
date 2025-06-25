package com.heartForecast.domain.heartShare.domain.repository;

import com.heartForecast.domain.heartShare.domain.HeartShare;
import com.heartForecast.domain.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeartShareRepository extends JpaRepository<HeartShare, Long> {
  List<HeartShare> findAllByUser(Users user);
}
