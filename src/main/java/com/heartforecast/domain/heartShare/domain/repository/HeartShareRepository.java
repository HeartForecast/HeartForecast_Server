package com.heartforecast.domain.heartShare.domain.repository;

import com.heartforecast.domain.heartShare.domain.HeartShare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartShareRepository extends JpaRepository<HeartShare, Long> {
}
