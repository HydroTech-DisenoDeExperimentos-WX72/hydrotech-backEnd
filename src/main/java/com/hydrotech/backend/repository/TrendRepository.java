package com.hydrotech.backend.repository;

import com.hydrotech.backend.model.Trend;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TrendRepository extends JpaRepository<Trend, Long> {

    /**
     * Checks if a trend with the specified name already exists.
     *
     * @param name The name of the trend.
     * @return True if a trend with the specified name exists, false otherwise.
     */
    Boolean existsByName(String name);
}

