package com.hydrotech.backend.service;

import com.hydrotech.backend.model.Trend;


public interface TrendService {

    /**
     * Creates a new trend.
     *
     * @param trend The trend to be created.
     * @return The created trend.
     */
    Trend createTrend(Trend trend);
}
