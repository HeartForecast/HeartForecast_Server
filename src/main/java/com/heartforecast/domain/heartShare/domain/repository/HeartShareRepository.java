package com.heartforecast.domain.heartShare.domain.repository;

import com.heartforecast.domain.heartShare.domain.HeartShare;
import com.heartforecast.domain.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeartShareRepository extends JpaRepository<HeartShare, Long> {
  Optional<HeartShare> findByIdAndUser(Long id, Users user);
  List<HeartShare> findAllByUser(Users user);
}
