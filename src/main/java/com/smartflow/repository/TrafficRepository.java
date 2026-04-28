package com.smartflow.repository;

import com.smartflow.model.TrafficData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrafficRepository extends JpaRepository<TrafficData, Long> {
}
